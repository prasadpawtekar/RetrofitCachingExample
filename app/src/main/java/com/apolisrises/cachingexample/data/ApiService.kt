package com.apolisrises.cachingexample.data

import android.content.Context
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search")
    suspend fun search(@Query("term") term: String): Response<ArtistSearchResponse>

    companion object {
        fun getApiService(context: Context) = ApiClient(context).retrofit.create(ApiService::class.java)
    }
}