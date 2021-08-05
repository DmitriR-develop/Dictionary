package com.dmitri.dictionary.di

import com.dmitri.dictionary.view.main.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ViewModelModule::class,
        RepositoryModule::class
    ]
)
interface AppComponent {

    fun inject(mainActivity: MainActivity)
}