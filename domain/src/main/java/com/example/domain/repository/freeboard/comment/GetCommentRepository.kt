package com.example.domain.repository.freeboard.comment

import com.example.domain.model.freeboard.comment.DomainGetCommentResponse

interface GetCommentRepository {
    suspend fun getComment(
        id: Int
    ): List<DomainGetCommentResponse>?
}