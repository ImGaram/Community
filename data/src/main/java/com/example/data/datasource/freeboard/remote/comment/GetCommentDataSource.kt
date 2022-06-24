package com.example.data.datasource.freeboard.remote.comment

import com.example.data.entity.freeboard.response.GetCommentResponse

interface GetCommentDataSource {
    suspend fun getComment(
        postId: Int,

    ): List<GetCommentResponse>?
}