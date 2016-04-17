package com.artufimtcev.ankobinding.sample.extension

fun <T : Any?> Array<T>.random() : T {
    return get((Math.random() * size).toInt())
}