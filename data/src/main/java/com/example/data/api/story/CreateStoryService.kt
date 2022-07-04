package com.example.data.api.story

import com.example.data.entity.story.request.CreateStoryRequest
import com.example.data.entity.story.response.BaseStoryResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface CreateStoryService {
    @POST("/SBN/CRE/")
    suspend fun createStory(
        @Body body: CreateStoryRequest
    ): Response<BaseStoryResponse>
}