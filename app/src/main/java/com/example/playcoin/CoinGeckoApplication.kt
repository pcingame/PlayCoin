package com.example.playcoin

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CoinGeckoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        App.context = this
        App.application = this
    }
}

@SuppressLint("StaticFieldLeak")
object App {
    lateinit var context: Context
    lateinit var application: CoinGeckoApplication
}
