package com.dmitri.dictionary.application

import android.app.Application
import com.dmitri.dictionary.di.application
import com.dmitri.dictionary.di.historyScreen
import com.dmitri.dictionary.di.mainScreen
import org.koin.core.context.startKoin

class TranslatorApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                application + mainScreen + historyScreen
            )
        }
    }
}