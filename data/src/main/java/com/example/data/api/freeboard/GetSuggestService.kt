package com.example.data.api.freeboard

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GetSuggestService {
    @GET("/suggest_fr/{board}")
    suspend fun getSuggest(
        @Path("board") board: Int
    ): Response<Int>
}