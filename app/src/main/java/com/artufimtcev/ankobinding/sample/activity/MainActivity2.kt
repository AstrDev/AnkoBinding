package com.artufimtcev.ankobinding.sample.activity

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import com.artufimtcev.ankobinding.sample.ui.KotlinActivityUI2
import org.jetbrains.anko.*

class MainActivity2 : AppCompatActivity() {

    lateinit var ui: KotlinActivityUI2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ui = KotlinActivityUI2()
        ui.build(this)


    }
}

class User(val name: String, val surname: String)