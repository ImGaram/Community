package com.example.data.datasource.freeboard.remote.comment

import com.example.data.entity.freeboard.request.AddCommentRequest

interface AddCommentDataSource {
    suspend fun createComment(
        body: AddCommentRequest
    ): Int?
}