package com.example.data.datasource.freeboard.remote.comment

import com.example.data.entity.freeboard.request.BaseCommentRequest

interface ModifyCommentDataSource {
    suspend fun modifyComment(
        pk: Int,
        body: BaseCommentRequest
    ): Int?
}