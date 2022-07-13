package com.example.data.api.story.comment

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GetSuggestService {
    @GET("/suggest_st/{story}")
    suspend fun getSuggest(
        @Path("story") story: Int
    ): Response<Int>
}