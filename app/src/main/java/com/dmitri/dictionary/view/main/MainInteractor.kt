package com.dmitri.dictionary.view.main

import com.dmitri.dictionary.di.NAME_LOCAL
import com.dmitri.dictionary.di.NAME_REMOTE
import com.dmitri.dictionary.model.data.AppState
import com.dmitri.dictionary.model.data.DataModel
import com.dmitri.dictionary.model.repository.Repository
import com.dmitri.dictionary.viewmodel.Interactor
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Named

class MainInteractor @Inject constructor(
    @Named(NAME_REMOTE) private val remoteRepository: Repository<List<DataModel>>,
    @Named(NAME_LOCAL) private val localRepository: Repository<List<DataModel>>
) : Interactor<AppState> {
    override fun getData(word: String, fromRemoteSource: Boolean): Observable<AppState> {
        return if (fromRemoteSource) {
            remoteRepository.getData(word).map { AppState.Success(it) }
        } else {
            localRepository.getData(word).map { AppState.Success(it) }
        }
    }
}