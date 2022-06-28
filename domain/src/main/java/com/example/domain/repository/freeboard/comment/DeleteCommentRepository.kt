package com.example.domain.repository.freeboard.comment

interface DeleteCommentRepository {
    suspend fun deleteComment(
        postId: Int
    ): Int?
}