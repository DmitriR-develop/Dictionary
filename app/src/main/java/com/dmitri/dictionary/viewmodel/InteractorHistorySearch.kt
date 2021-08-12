package com.dmitri.dictionary.viewmodel

interface InteractorHistorySearch<T> {
    suspend fun getDataByWord(word: String, fromRemoteSource: Boolean): T
}