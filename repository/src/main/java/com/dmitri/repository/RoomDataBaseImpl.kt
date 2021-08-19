package com.dmitri.repository

import com.dmitri.dictionary.model.data.AppState
import com.dmitri.dictionary.model.data.DataModel
import com.dmitri.dictionary.utils.convertDataModelSuccessToEntity
import com.dmitri.dictionary.utils.mapHistoryEntityToSearchResult
import com.dmitri.dictionary.utils.mapHistoryEntityToSearchResultOneWord
import com.dmitri.repository.room.HistoryDao

class RoomDataBaseImpl(private val historyDao: HistoryDao) : DataSourceLocal<DataModel> {
    override suspend fun getData(word: String): List<DataModel> {
        return mapHistoryEntityToSearchResult(historyDao.all())
    }

    override suspend fun saveToDB(appState: AppState) {
        convertDataModelSuccessToEntity(appState)?.let {
            historyDao.insert(it)
        }
    }

    override suspend fun getDataByWord(word: String): DataModel {
        return mapHistoryEntityToSearchResultOneWord(historyDao.getDataByWord(word))
    }
}