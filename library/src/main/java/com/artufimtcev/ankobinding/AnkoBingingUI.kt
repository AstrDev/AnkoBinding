package com.artufimtcev.ankobinding

import android.content.Context
import android.util.Log
import android.view.View
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.button
import org.jetbrains.anko.verticalLayout
import java.util.*

abstract class AnkoBingingUI<ID : Enum<ID>, C : Context>(context: C) : AnkoUI<C>(context), AnkoObserver<ID> {

    private val usedBindings : MutableMap<ID, Binding<out View>>

    init {
        usedBindings = HashMap()
    }


    override fun notifyChange(id: ID) {
        usedBindings[id]?.rebind()
    }


    override fun notifyChange() {
        usedBindings.forEach {
            it.value.rebind()
        }
    }


    fun registerTo(observer: AnkoObservable<ID>?) {
        observer?.registerObserver(this)
    }


    fun unregisterFrom(observer: AnkoObservable<ID>?) {
        observer?.unregisterObserver(this)
    }


    protected fun <V : View> V.bind(id: ID, binding: V.() -> Unit) : V {
        binding()
        val bindingObject = Binding(this, binding)
        if (!usedBindings.contains(id)) {
            usedBindings.put(id, bindingObject)
        } else {
//             TODO: Force user to make unique bindings?
        }

        return this
    }


    private class Binding<V : View>(val view: V, val bindingBlock: V.() -> Unit) {

        fun rebind() {
            view.bindingBlock()
        }
    }
}
