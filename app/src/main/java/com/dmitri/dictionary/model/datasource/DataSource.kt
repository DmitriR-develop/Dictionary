package com.dmitri.dictionary.model.datasource

interface DataSource<T> {
    suspend fun getData(word: String): List<T>
}