package com.example.data.api.freeboard

import com.example.data.entity.freeboard.request.SuggestPostRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SuggestService {
    @POST("/suggest_fr/")
    suspend fun suggestPost(
        @Body body: SuggestPostRequest
    ): Response<Int>
}