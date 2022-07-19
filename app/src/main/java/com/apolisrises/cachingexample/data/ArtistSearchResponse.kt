package com.apolisrises.cachingexample.data

data class ArtistSearchResponse(
    val resultCount: Int,
    val results: List<Result>
)