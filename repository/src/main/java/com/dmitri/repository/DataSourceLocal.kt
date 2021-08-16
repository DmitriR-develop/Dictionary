package com.dmitri.repository

import com.dmitri.dictionary.model.data.AppState

interface DataSourceLocal<T> : DataSource<T> {
    suspend fun saveToDB(appState: AppState)
    suspend fun getDataByWord(word: String): T
}