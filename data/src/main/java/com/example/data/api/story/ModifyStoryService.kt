package com.example.data.api.story

import com.example.data.entity.story.request.CreateStoryRequest
import com.example.data.entity.story.response.BaseStoryResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.PUT
import retrofit2.http.Path

interface ModifyStoryService {
    @PUT("/SBN/{story}")
    suspend fun modifyStory(
        @Path("story") story: Int,
        @Body body: CreateStoryRequest
    ): Response<BaseStoryResponse>
}