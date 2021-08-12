package com.dmitri.dictionary.model.repository

import com.dmitri.dictionary.model.data.AppState
import com.dmitri.dictionary.model.data.DataModel
import com.dmitri.dictionary.model.datasource.DataSourceLocal

class RepositoryLocalImpl(private val dataSource: DataSourceLocal<DataModel>) :
    RepositoryLocal<DataModel> {

    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }

    override suspend fun saveToDb(appState: AppState) {
        dataSource.saveToDB(appState)
    }

    override suspend fun getDataByWord(word: String): DataModel {
        return dataSource.getDataByWord(word)
    }
}