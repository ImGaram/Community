package com.example.presentation.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
open class App: Application() {
    companion object {
        lateinit var instance: App
        private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}