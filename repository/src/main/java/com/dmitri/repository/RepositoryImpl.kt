package com.dmitri.repository

import com.dmitri.dictionary.model.data.DataModel

class RepositoryImpl(private val dataSource: com.dmitri.repository.DataSource<DataModel>) :
    Repository<DataModel> {
    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }
}