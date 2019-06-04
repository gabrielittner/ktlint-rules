package com.gabrielittner.ktlint

import com.pinterest.ktlint.core.RuleSet
import com.pinterest.ktlint.core.RuleSetProvider
import com.pinterest.ktlint.ruleset.experimental.ImportOrderingRule
import com.pinterest.ktlint.ruleset.standard.NoWildcardImportsRule
import com.pinterest.ktlint.ruleset.standard.PackageNameRule

class CustomRuleSetProvider : RuleSetProvider {
    override fun get(): RuleSet {
        return RuleSet("custom",
                ImportOrderingRule(),
                PackageNameRule(),
                NoWildcardImportsRule())
    }
}
