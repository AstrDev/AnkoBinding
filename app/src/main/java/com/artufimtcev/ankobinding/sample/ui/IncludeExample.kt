package com.artufimtcev.ankobinding.sample.ui


import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.ViewGroup
import android.view.ViewManager
import android.widget.Button
import android.widget.TextView
import com.artufimtcev.ankobinding.sample.R
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar
import org.jetbrains.anko.custom.ankoView


open class ToolbarActivityUI {

    lateinit var toolbar: Toolbar

    protected fun ViewManager.exampleToolbar(title: String) : Toolbar {
        toolbar = toolbar {
            this.title = title
        }
        return toolbar
    }
}


class KotlinActivityUI : ToolbarActivityUI() {

    lateinit var button: Button
    lateinit var textView: TextView

    fun build(activity: AppCompatActivity) {

        activity.verticalLayout(fun() {})
    }
}