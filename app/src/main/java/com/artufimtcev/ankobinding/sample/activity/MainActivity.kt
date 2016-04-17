package com.artufimtcev.ankobinding.sample.activity

import android.app.Activity
import android.os.Bundle
import com.artufimtcev.ankobinding.sample.entity.User
import com.artufimtcev.ankobinding.sample.ui.MainActivityUI
import com.artufimtcev.ankobinding.sample.viewmodel.UserViewModel

class MainActivity: Activity() {

    lateinit var ui: MainActivityUI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ui = MainActivityUI(this)
        ui.createView()
        ui.viewModel = UserViewModel(User("", "", 0))
    }
}