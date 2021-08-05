package com.dmitri.dictionary.model.datasource

import com.dmitri.dictionary.model.data.DataModel

class DataSourceLocal(private val localProvider: RoomDataBaseImpl) : DataSource<List<DataModel>> {
    override suspend fun getData(word: String): List<DataModel> = localProvider.getData(word)
}