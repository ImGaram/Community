package com.example.data.api.story

import com.example.data.entity.story.request.CreateCommentRequest
import com.example.data.entity.story.response.CreateCommentResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface CreateStoryCommentService {
    @POST("/CST/")
    suspend fun createStoryComment(
        @Body body: CreateCommentRequest
    ): Response<CreateCommentResponse>
}