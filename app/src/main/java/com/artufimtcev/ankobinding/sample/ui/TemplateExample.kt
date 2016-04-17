package com.artufimtcev.ankobinding.sample.ui


import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.ViewGroup
import android.view.ViewManager
import android.widget.Button
import android.widget.TextView
import com.artufimtcev.ankobinding.sample.activity.User
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar


abstract class ToolbarActivityUI2 {

    lateinit var toolbar: Toolbar


    protected fun ViewManager.exampleToolbar(title: String): Toolbar {
        toolbar = toolbar {
            this.title = title
        }

        return toolbar
    }


    fun build(activity: AppCompatActivity) {
        activity.verticalLayout {
            exampleToolbar("Some Title")

            layout()
        }
    }

    protected abstract fun ViewManager.layout()
}


class KotlinActivityUI2 : ToolbarActivityUI2() {

    lateinit var button: Button
    lateinit var textView: TextView

    var user: User? = null

    override fun ViewManager.layout() {
        verticalLayout {
            button = button {
                text = "jaja"
            }.lparams {
                width = matchParent
                height = wrapContent
            }

            textView = textView {
                text = user?.name
            }.lparams {
                width = matchParent
                height = wrapContent
            }
        }
    }
}