package com.example.data.api.story.comment

import com.example.data.entity.story.request.CreateCommentRequest
import com.example.data.entity.story.response.BaseCommentResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface CreateStoryCommentService {
    @POST("/CST/")
    suspend fun createStoryComment(
        @Body body: CreateCommentRequest
    ): Response<BaseCommentResponse>
}