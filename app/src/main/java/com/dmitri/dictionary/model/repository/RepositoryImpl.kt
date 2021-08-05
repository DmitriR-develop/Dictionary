package com.dmitri.dictionary.model.repository

import com.dmitri.dictionary.model.data.DataModel
import com.dmitri.dictionary.model.datasource.DataSource
import io.reactivex.Observable

class RepositoryImpl(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {
    override fun getData(word: String): Observable<List<DataModel>> {
        return dataSource.getData(word)
    }
}