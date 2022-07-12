package com.example.domain.repository.story.comment

import com.example.domain.model.story.DomainBaseCommentResponse

interface CreateCommentRepository {
    suspend fun createComment(
        context: String,
        createIdUserSt: Int,
        commentStory: Int
    ): DomainBaseCommentResponse?
}