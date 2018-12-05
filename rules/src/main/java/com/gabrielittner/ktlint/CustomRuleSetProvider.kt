package com.gabrielittner.ktlint

import com.github.shyiko.ktlint.core.RuleSet
import com.github.shyiko.ktlint.core.RuleSetProvider

class CustomRuleSetProvider : RuleSetProvider {
    override fun get(): RuleSet {
        return RuleSet("custom", CustomImportOrderingRule())
    }
}
