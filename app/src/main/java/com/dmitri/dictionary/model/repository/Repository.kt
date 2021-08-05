package com.dmitri.dictionary.model.repository

interface Repository<T> {
    suspend fun getData(word: String): T
}