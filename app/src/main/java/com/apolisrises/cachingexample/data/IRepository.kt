package com.apolisrises.cachingexample.data

import retrofit2.Response

interface IRepository {
    suspend fun search(term: String): Response<ArtistSearchResponse>
}