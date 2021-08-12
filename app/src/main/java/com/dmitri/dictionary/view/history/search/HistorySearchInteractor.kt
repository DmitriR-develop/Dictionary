package com.dmitri.dictionary.view.history.search

import com.dmitri.dictionary.model.data.AppState
import com.dmitri.dictionary.model.data.DataModel
import com.dmitri.dictionary.model.repository.RepositoryLocal
import com.dmitri.dictionary.viewmodel.InteractorHistorySearch

class HistorySearchInteractor(
    private val localRepository: RepositoryLocal<DataModel>
) : InteractorHistorySearch<AppState> {
    override suspend fun getDataByWord(word: String, fromRemoteSource: Boolean): AppState {
        val searchResult = localRepository.getDataByWord(word)
        return AppState.Success(listOf(searchResult))
    }
}