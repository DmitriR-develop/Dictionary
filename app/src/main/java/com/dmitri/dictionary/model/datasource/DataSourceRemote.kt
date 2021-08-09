package com.dmitri.dictionary.model.datasource

import com.dmitri.dictionary.model.data.DataModel

class DataSourceRemote(private val remoteProvider: RetrofitImpl) : DataSource<List<DataModel>> {
    override suspend fun getData(word: String): List<DataModel> = remoteProvider.getData(word)
}