package com.dmitri.dictionary.model.repository

import com.dmitri.dictionary.model.data.DataModel
import com.dmitri.dictionary.model.datasource.DataSource

class RepositoryImpl(private val dataSource: DataSource<DataModel>) :
    Repository<DataModel> {
    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }
}