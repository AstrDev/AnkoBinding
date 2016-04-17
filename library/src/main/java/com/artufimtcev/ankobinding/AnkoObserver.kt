package com.artufimtcev.ankobinding

interface AnkoObserver<E : Enum<E>> {

    fun notifyChange(id: E)
    fun notifyChange()
}