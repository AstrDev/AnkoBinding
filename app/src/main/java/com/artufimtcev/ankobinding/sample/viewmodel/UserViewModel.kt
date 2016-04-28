package com.artufimtcev.ankobinding.sample.viewmodel

import com.artufimtcev.ankobinding.AnkoBaseObservable
import com.artufimtcev.ankobinding.sample.entity.User
import com.artufimtcev.ankobinding.sample.extension.random
import com.artufimtcev.ankobinding.sample.ui.MainActivityUI

class UserViewModel(private val user: User) : AnkoBaseObservable<MainActivityUI.id>() {

    val names: Array<String> = arrayOf("Michael", "Sherwood", "Don", "Lowell", "Lindsay", "Otis", "Hilton", "Luke", "Raleigh", "Lino")
    val surnames: Array<String> = arrayOf("Pines", "Boston", "Harpin", "Soles", "Folkerts", "Mohan", "Botsford", "Casto", "Cornette", "Liddle")

    var name: String by bindingObservable(MainActivityUI.id.Name, user.name)

    var surname: String by bindingObservable(MainActivityUI.id.Surname, user.surname)

    var age: Int by bindingObservable(MainActivityUI.id.Age, user.age)

    fun generate() {
        name = names.random()
        surname = surnames.random()
        age = (Math.random() * 100).toInt()
    }
}