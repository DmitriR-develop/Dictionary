package com.dmitri.dictionary.application

import android.app.Application
import com.dmitri.dictionary.di.AppComponent
import com.dmitri.dictionary.di.DaggerAppComponent

class TranslatorApp : Application() {
    companion object {
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder().build()
    }
}