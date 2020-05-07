package com.example.retrofittrial

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface RetrofitClient {
    companion object{
        var retrofit = Retrofit.Builder().baseUrl("https://github-trending-api.now.sh")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
}