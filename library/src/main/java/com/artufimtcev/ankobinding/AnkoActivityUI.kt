package com.artufimtcev.ankobinding

import android.app.Activity
import android.content.res.Configuration
import org.jetbrains.anko.configuration

abstract class AnkoActivityUI<ID : Enum<ID>>(activity: Activity) : AnkoBingingUI<ID, Activity>(activity) {

    var configuration: Configuration = activity.configuration
    private set


}