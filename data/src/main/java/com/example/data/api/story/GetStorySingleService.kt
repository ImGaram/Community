package com.example.data.api.story

import com.example.data.entity.story.response.BaseStoryResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GetStorySingleService {
    @GET("/SBN/{pk}")
    suspend fun getSingleStory(
        @Path("pk") storyId: Int,
    ): Response<BaseStoryResponse>
}