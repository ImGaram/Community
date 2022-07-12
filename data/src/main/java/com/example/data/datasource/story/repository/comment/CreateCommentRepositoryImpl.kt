package com.example.data.datasource.story.repository.comment

import com.example.data.datasource.story.datasource.comment.CreateCommentDataSource
import com.example.data.entity.story.request.CreateCommentRequest
import com.example.domain.model.story.DomainCommentResponse
import com.example.domain.repository.story.comment.CreateCommentRepository
import javax.inject.Inject

class CreateCommentRepositoryImpl @Inject constructor(
    private val dataSource: CreateCommentDataSource
): CreateCommentRepository {
    override suspend fun createComment(
        context: String,
        createIdUserSt: Int,
        commentStory: Int
    ): DomainCommentResponse? {
        return dataSource.createComment(CreateCommentRequest(context, createIdUserSt, commentStory))
    }
}