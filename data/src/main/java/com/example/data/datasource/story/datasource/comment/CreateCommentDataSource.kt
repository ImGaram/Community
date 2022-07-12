package com.example.data.datasource.story.datasource.comment

import com.example.data.entity.story.request.CreateCommentRequest
import com.example.data.entity.story.response.CreateCommentResponse

interface CreateCommentDataSource {
    suspend fun createComment(
        body: CreateCommentRequest
    ): CreateCommentResponse?
}