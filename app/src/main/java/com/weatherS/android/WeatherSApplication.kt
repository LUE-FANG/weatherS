package com.weatherS.android

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class WeatherSApplication : Application() {

    companion object {
        const val TOKEN = "igqkC5XWFhtBUOE4"

        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

}