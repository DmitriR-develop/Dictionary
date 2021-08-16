package com.dmitri.dictionary.view.main

import com.dmitri.dictionary.model.data.AppState
import com.dmitri.dictionary.model.data.DataModel
import com.dmitri.repository.Repository
import com.dmitri.repository.RepositoryLocal
import com.dmitri.core.viewmodel.Interactor

class MainInteractor(
    private val remoteRepository: com.dmitri.repository.Repository<DataModel>,
    private val localRepository: com.dmitri.repository.RepositoryLocal<DataModel>
) : com.dmitri.core.viewmodel.Interactor<AppState> {
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