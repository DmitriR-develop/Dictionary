package com.dmitri.dictionary.di

import androidx.room.Room
import com.dmitri.dictionary.model.data.DataModel
import com.dmitri.dictionary.model.datasource.RetrofitImpl
import com.dmitri.dictionary.model.datasource.RoomDataBaseImpl
import com.dmitri.dictionary.model.repository.Repository
import com.dmitri.dictionary.model.repository.RepositoryImpl
import com.dmitri.dictionary.model.repository.RepositoryLocal
import com.dmitri.dictionary.model.repository.RepositoryLocalImpl
import com.dmitri.dictionary.room.HistoryDatabase
import com.dmitri.dictionary.view.history.HistoryInteractor
import com.dmitri.dictionary.view.history.HistoryViewModel
import com.dmitri.dictionary.view.history.search.HistorySearchInteractor
import com.dmitri.dictionary.view.history.search.HistorySearchViewModel
import com.dmitri.dictionary.view.main.MainInteractor
import com.dmitri.dictionary.view.main.MainViewModel
import org.koin.dsl.module

val application = module {
    single { Room.databaseBuilder(get(), HistoryDatabase::class.java, "HistoryDB").build() }
    single { get<HistoryDatabase>().historyDao() }
    single<Repository<DataModel>> { RepositoryImpl(RetrofitImpl()) }
    single<RepositoryLocal<DataModel>> { RepositoryLocalImpl(RoomDataBaseImpl(get())) }
}

val mainScreen = module {
    factory { MainInteractor(get(), get()) }
    factory { MainViewModel(get()) }
}

val historyScreen = module {
    factory { HistoryInteractor(get()) }
    factory { HistoryViewModel(get()) }
}

val historySearchScreen = module {
    factory { HistorySearchInteractor(get()) }
    factory { HistorySearchViewModel(get()) }
}