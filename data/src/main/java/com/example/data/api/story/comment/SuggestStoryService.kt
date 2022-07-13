package com.example.data.api.story.comment

import com.example.data.entity.story.request.SuggestStoryRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SuggestStoryService {
    @POST("/suggest_st/")
    suspend fun suggestStory(
        @Body body: SuggestStoryRequest
    ): Response<Int>
}