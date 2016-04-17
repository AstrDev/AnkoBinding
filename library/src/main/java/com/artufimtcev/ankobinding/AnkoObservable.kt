package com.artufimtcev.ankobinding

interface AnkoObservable<ID : Enum<ID>> {

    fun registerObserver(observer: AnkoObserver<ID>)
    fun unregisterObserver(observer: AnkoObserver<ID>)
    fun notifyDataChanged(id: ID)
    fun notifyDataChanged()
}