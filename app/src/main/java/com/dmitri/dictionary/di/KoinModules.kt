package com.dmitri.dictionary.di

import com.dmitri.dictionary.model.data.DataModel
import com.dmitri.dictionary.model.datasource.RetrofitImpl
import com.dmitri.dictionary.model.datasource.RoomDataBaseImpl
import com.dmitri.dictionary.model.repository.Repository
import com.dmitri.dictionary.model.repository.RepositoryImpl
import com.dmitri.dictionary.view.main.MainInteractor
import com.dmitri.dictionary.view.main.MainViewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val application = module {
    single<Repository<List<DataModel>>>(named(NAME_REMOTE)) { RepositoryImpl(RetrofitImpl()) }
    single<Repository<List<DataModel>>>(named(NAME_LOCAL)) { RepositoryImpl(RoomDataBaseImpl()) }
}

val mainScreen = module {
    factory { MainInteractor(get(named(NAME_REMOTE)), get(named(NAME_LOCAL))) }
    factory { MainViewModel(get()) }
}