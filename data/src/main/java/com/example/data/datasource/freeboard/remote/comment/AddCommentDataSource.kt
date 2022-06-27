package com.example.data.datasource.freeboard.remote.comment

import com.example.data.entity.freeboard.request.BaseCommentRequest

interface AddCommentDataSource {
    suspend fun createComment(
        body: BaseCommentRequest
    ): Int?
}