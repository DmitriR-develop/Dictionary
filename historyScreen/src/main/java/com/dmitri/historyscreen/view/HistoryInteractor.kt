package com.dmitri.dictionary.view.history

import com.dmitri.dictionary.model.data.AppState
import com.dmitri.dictionary.model.data.DataModel
import com.dmitri.dictionary.model.repository.RepositoryLocal
import com.dmitri.core.viewmodel.Interactor

class HistoryInteractor(
    private val localRepository: RepositoryLocal<DataModel>
) : com.dmitri.core.viewmodel.Interactor<AppState> {
    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(localRepository.getData(word))
    }
}