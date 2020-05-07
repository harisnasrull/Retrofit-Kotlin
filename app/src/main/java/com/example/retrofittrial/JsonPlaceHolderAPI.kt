package com.example.retrofittrial

import retrofit2.Call
import retrofit2.http.GET

interface JsonPlaceHolderAPI {
    @GET("/repositories")
    fun getAllPhotos(): Call<List<Photo>>
}