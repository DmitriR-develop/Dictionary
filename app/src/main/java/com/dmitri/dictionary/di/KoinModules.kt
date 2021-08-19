package com.dmitri.dictionary.di

import androidx.room.Room
import com.dmitri.dictionary.model.data.DataModel
import com.dmitri.dictionary.view.main.MainInteractor
import com.dmitri.dictionary.view.main.MainViewModel
import com.dmitri.repository.*
import com.dmitri.repository.room.HistoryDatabase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

fun injectDependencies() = loadModules

private val loadModules by lazy {
    loadKoinModules(listOf(application, mainScreen))
}

val application = module {
    single { Room.databaseBuilder(get(), HistoryDatabase::class.java, "HistoryDB").build() }
    single { get<HistoryDatabase>().historyDao() }
    single<Repository<DataModel>> { RepositoryImpl(RetrofitImpl()) }
    single<RepositoryLocal<DataModel>> { RepositoryLocalImpl(RoomDataBaseImpl(get())) }
}

val mainScreen = module {
    factory { MainInteractor(get(), get()) }
    viewModel { MainViewModel(get()) }
}