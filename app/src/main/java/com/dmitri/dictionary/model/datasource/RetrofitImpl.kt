package com.dmitri.dictionary.model.datasource

import com.dmitri.dictionary.model.data.DataModel
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitImpl : DataSource<List<DataModel>> {
    override suspend fun getData(word: String): List<DataModel> {
        return Retrofit.Builder()
            .baseUrl(BASE_URL_LOCATIONS)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create())).build()
            .create(ApiService::class.java).searchAsync(word).await()
    }

    companion object {
        private const val BASE_URL_LOCATIONS = "https://dictionary.skyeng.ru/api/public/v1/"
    }
}