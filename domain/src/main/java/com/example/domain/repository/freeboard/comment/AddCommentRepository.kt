package com.example.domain.repository.freeboard.comment

interface AddCommentRepository {
    suspend fun createComment(
        context: String,
        createIdUser: Int,
        commentPost: Int
    ): Int?
}