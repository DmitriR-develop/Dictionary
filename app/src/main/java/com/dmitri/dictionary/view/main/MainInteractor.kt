package com.dmitri.dictionary.view.main

import com.dmitri.dictionary.model.data.AppState
import com.dmitri.dictionary.model.data.DataModel
import com.dmitri.dictionary.model.repository.Repository
import com.dmitri.dictionary.model.repository.RepositoryLocal
import com.dmitri.dictionary.viewmodel.Interactor

class MainInteractor(
    private val remoteRepository: Repository<DataModel>,
    private val localRepository: RepositoryLocal<DataModel>
) : Interactor<AppState> {
    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        val appState: AppState
        if (fromRemoteSource) {
            appState = AppState.Success(remoteRepository.getData(word))
            localRepository.saveToDb(appState)
        } else {
            appState = AppState.Success(localRepository.getData(word))
        }
        return appState
    }
}