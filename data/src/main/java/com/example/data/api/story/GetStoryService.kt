package com.example.data.api.story

import com.example.data.entity.story.response.BaseStoryResponse
import retrofit2.Response
import retrofit2.http.GET

interface GetStoryService {
    @GET("/SBN/")
    suspend fun getStory(): Response<List<BaseStoryResponse>>
}