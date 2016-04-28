package com.artufimtcev.ankobinding

import java.util.*
import kotlin.reflect.KProperty

open class AnkoBaseObservable<ID : Enum<ID>> : AnkoObservable<ID> {

    private val observers: MutableSet<AnkoObserver<ID>> = HashSet()

    override fun notifyDataChanged() {
        observers.forEach {
            it.notifyChange()
        }
    }

    override fun notifyDataChanged(id: ID) {
        observers.forEach {
            it.notifyChange(id)
        }
    }

    override fun registerObserver(observer: AnkoObserver<ID>) {
        observers.add(observer)
    }

    override fun unregisterObserver(observer: AnkoObserver<ID>) {
        observers.remove(observer)
    }


    protected fun <T> bindingObservable(id: ID, initialValue: T) : ObservablePropertyDelegate<T> {
        return ObservablePropertyDelegate(id, initialValue)
    }


    inner class ObservablePropertyDelegate<T>(val id: ID, initialValue: T) {

        var value: T = initialValue

        operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
            return value
        }

        operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
            this.value = value
            notifyDataChanged(id)
        }
    }
}