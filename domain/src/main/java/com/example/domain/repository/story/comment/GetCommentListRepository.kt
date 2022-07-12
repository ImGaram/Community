package com.example.domain.repository.story.comment

import com.example.domain.model.story.DomainBaseCommentResponse

interface GetCommentListRepository {
    suspend fun getCommentList(
        story: Int
    ): List<DomainBaseCommentResponse>?
}