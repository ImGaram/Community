package com.example.domain.repository.freeboard.comment

interface ModifyCommentRepository {
    suspend fun modifyComment(
        context: String,
        createIdUser: Int,
        commentPost: Int,
        pk: Int
    ): Int?
}