package com.gabrielittner.ktlint

import com.github.shyiko.ktlint.core.Rule
import org.jetbrains.kotlin.com.intellij.lang.ASTNode
import org.jetbrains.kotlin.com.intellij.psi.PsiWhiteSpace
import org.jetbrains.kotlin.com.intellij.psi.impl.source.tree.PsiWhiteSpaceImpl
import org.jetbrains.kotlin.psi.stubs.elements.KtStubElementTypes.IMPORT_DIRECTIVE
import org.jetbrains.kotlin.psi.stubs.elements.KtStubElementTypes.IMPORT_LIST

/**
 * Android Studio:
 *   Alphabetical with capital letters before lower case letters (e.g. Z before a).
 *   No blank lines between major groups (android, com, junit, net, org, java, javax).
 *   Single group regardless of import type.
 */
class CustomImportOrderingRule : Rule("custom-import-ordering") {

    override fun visit(
            node: ASTNode,
            autoCorrect: Boolean,
            emit: (offset: Int, errorMessage: String, canBeAutoCorrected: Boolean) -> Unit
    ) {
        if (node.elementType != IMPORT_LIST) {
            return
        }

        val children = node.getChildren(null)
        if (children.isEmpty()) {
            return
        }

        val imports = children.filter { it.elementType == IMPORT_DIRECTIVE }
        val sortedImports = imports.sortedBy { it.text }

        if (imports != sortedImports || hasTooMuchWhitespace(children)) {
            emit(node.startOffset, "Imports must be ordered in lexicographic order in a single group", true)
            if (autoCorrect) {
                autoCorrectImports(node, sortedImports)
            }
        }
    }

    private fun hasTooMuchWhitespace(nodes: Array<ASTNode>): Boolean {
        return nodes.any { it is PsiWhiteSpace && (it as PsiWhiteSpace).text != "\n" }
    }

    private fun autoCorrectImports(node: ASTNode, sortedImports: List<ASTNode>) {
        node.removeRange(node.firstChildNode, node.lastChildNode.treeNext)
        sortedImports.forEachIndexed { i, astNode ->
            if (i > 0) {
                node.addChild(PsiWhiteSpaceImpl("\n"), null)
            }
            node.addChild(astNode, null)
        }
    }
}
