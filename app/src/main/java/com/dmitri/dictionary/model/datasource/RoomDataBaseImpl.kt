package com.dmitri.dictionary.model.datasource

import com.dmitri.dictionary.model.data.DataModel

class RoomDataBaseImpl : DataSource<List<DataModel>> {
    override suspend fun getData(word: String): List<DataModel> {
        TODO("Not yet implemented")
    }
}