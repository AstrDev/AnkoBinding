package com.artufimtcev.ankobinding.sample.ui

import android.app.Activity
import android.widget.Button
import com.artufimtcev.ankobinding.AnkoActivityUI
import com.artufimtcev.ankobinding.sample.R
import com.artufimtcev.ankobinding.sample.viewmodel.UserViewModel
import org.jetbrains.anko.*

class MainActivityUI(activity: Activity) : AnkoActivityUI<MainActivityUI.id>(activity) {

    enum class id {
        Name, Surname, Age
    }

    var viewModel: UserViewModel? = null
    set(value) {
        unregisterFrom(viewModel)
        field = value
        registerTo(viewModel)
    }

    lateinit var generateButton: Button


    override fun AnkoContext<Activity>.build() {
        verticalLayout {

            generateButton = button("Generate!") {
                onClick { viewModel?.generate() }
            }

            textView {

            }.bind(MainActivityUI.id.Name) {
                text = viewModel?.name ?: context.getString(R.string.text_view_placeholder)
            }

            textView {

            }.bind(MainActivityUI.id.Surname) {
                text = viewModel?.surname ?: context.getString(R.string.text_view_placeholder)
            }

            textView {

            }.bind(MainActivityUI.id.Age) {
                text = viewModel?.age?.toString() ?: context.getString(R.string.text_view_placeholder)
            }
        }
    }
}