package com.dmitri.dictionary.di

import androidx.room.Room
import com.dmitri.dictionary.model.data.DataModel
import com.dmitri.dictionary.view.history.HistoryInteractor
import com.dmitri.dictionary.view.history.HistoryViewModel
import com.dmitri.dictionary.view.history.search.HistorySearchInteractor
import com.dmitri.dictionary.view.history.search.HistorySearchViewModel
import com.dmitri.dictionary.view.main.MainInteractor
import com.dmitri.dictionary.view.main.MainViewModel
import com.dmitri.repository.room.HistoryDatabase
import org.koin.dsl.module

val application = module {
    single { Room.databaseBuilder(get(), HistoryDatabase::class.java, "HistoryDB").build() }
    single { get<HistoryDatabase>().historyDao() }
    single<com.dmitri.repository.Repository<DataModel>> { com.dmitri.repository.RepositoryImpl(com.dmitri.repository.RetrofitImpl()) }
    single<com.dmitri.repository.RepositoryLocal<DataModel>> {
        com.dmitri.repository.RepositoryLocalImpl(
            com.dmitri.repository.RoomDataBaseImpl(
                get()
            )
        )
    }
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