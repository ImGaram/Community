package com.example.data.api.story

import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.Path

interface DeleteStoryService {
    @DELETE("/SBN/{story}")
    suspend fun deleteStory(
        @Path("story") story: Int
    ): Response<Int>
}