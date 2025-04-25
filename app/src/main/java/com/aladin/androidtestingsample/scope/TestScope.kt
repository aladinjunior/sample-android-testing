package com.aladin.androidtestingsample.scope

import com.aladin.androidtestingsample.contract.ActScope
import com.aladin.androidtestingsample.contract.ArrangeScope
import com.aladin.androidtestingsample.contract.AssertScope

class TestScope<ARG: ArrangeScope, ACT: ActScope, AST: AssertScope>(
    private val arrange: ARG,
    private val act: ACT,
    private val assert: AST
) {
    fun launch(block: TestScope<ARG, ACT, AST>.() -> Unit) {
        apply(block)
    }

    fun arrange(onArrange: ARG.() -> Unit): TestScope<ARG, ACT, AST> {
        arrange.onArrange()
        return this
    }

    fun act(onAct: ACT.() -> Unit): TestScope<ARG, ACT, AST> {
        act.onAct()
        return this
    }

    fun assert(onAssert: AST.() -> Unit): TestScope<ARG, ACT, AST>  {
        assert.onAssert()
        return this
    }

}

inline fun <reified ARG: ArrangeScope, reified ACT: ActScope, reified AST: AssertScope>createScope(): TestScope<ARG, ACT, AST> {
    return TestScope(
        arrange = ARG::class.java.getDeclaredConstructor().newInstance(),
        act = ACT::class.java.getDeclaredConstructor().newInstance(),
        assert= AST::class.java.getDeclaredConstructor().newInstance()
    )
}
