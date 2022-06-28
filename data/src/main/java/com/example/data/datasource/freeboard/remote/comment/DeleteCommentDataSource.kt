package com.example.data.datasource.freeboard.remote.comment

interface DeleteCommentDataSource {
    suspend fun deleteComment(
        postId: Int
    ): Int?
}