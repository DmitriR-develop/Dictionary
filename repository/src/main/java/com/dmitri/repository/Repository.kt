package com.dmitri.repository

interface Repository<T> {
    suspend fun getData(word: String): List<T>
}