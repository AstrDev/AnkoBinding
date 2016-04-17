package com.artufimtcev.ankobinding

import java.util.*

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
}