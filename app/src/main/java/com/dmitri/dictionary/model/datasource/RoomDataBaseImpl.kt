package com.dmitri.dictionary.model.datasource

import com.dmitri.dictionary.model.data.DataModel
import io.reactivex.Observable

class RoomDataBaseImpl:DataSource<List<DataModel>> {
    override fun getData(word: String): Observable<List<DataModel>> {
        TODO("Not yet implemented")
    }
}