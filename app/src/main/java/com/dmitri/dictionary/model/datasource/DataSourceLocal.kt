package com.dmitri.dictionary.model.datasource

import com.dmitri.dictionary.model.data.AppState

interface DataSourceLocal<T> : DataSource<T> {
    suspend fun saveToDB(appState: AppState)
    suspend fun getDataByWord(word: String): T
}