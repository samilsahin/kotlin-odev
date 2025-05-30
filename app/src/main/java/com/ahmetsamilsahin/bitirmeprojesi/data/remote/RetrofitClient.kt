package com.ahmetsamilsahin.bitirmeprojesi.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val BASE_URL = "http://kasimadalan.pe.hu/"

    val yemekApi: YemekApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(YemekApi::class.java)
    }
}
