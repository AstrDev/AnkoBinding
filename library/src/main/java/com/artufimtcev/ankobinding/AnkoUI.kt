package com.artufimtcev.ankobinding

import android.app.Activity
import android.content.Context
import android.view.View
import org.jetbrains.anko.AnkoContext

abstract class AnkoUI<C : Context>(context: C) {

    val root: View get() = ankoContext.view

    protected val ankoContext: AnkoContext<C>

    init {
        ankoContext = AnkoContext.create(context, context)
    }

    fun createView() {
        ankoContext.build()
        (ankoContext.owner as? Activity)?.setContentView(root)
    }

    protected abstract fun AnkoContext<C>.build()
}