package com.apolisrises.cachingexample.data

import retrofit2.Response

class Repository(val apiService: ApiService): IRepository {
    override suspend fun search(term: String) = apiService.search(term)
}