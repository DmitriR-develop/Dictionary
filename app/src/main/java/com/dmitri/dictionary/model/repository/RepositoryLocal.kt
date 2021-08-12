package com.dmitri.dictionary.model.repository

import com.dmitri.dictionary.model.data.AppState

interface RepositoryLocal<T> : Repository<T> {
    suspend fun saveToDb(appState: AppState)
    suspend fun getDataByWord(word: String): T
}