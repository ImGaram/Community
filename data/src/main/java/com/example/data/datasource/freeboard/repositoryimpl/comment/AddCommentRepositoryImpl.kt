package com.example.data.datasource.freeboard.repositoryimpl.comment

import com.example.data.datasource.freeboard.remote.comment.AddCommentDataSource
import com.example.data.entity.freeboard.request.BaseCommentRequest
import com.example.domain.repository.freeboard.comment.AddCommentRepository
import javax.inject.Inject

class AddCommentRepositoryImpl @Inject constructor(
    private val dataSource: AddCommentDataSource
): AddCommentRepository {
    override suspend fun createComment(context: String, createIdUser: Int, commentPost: Int): Int? {
        return dataSource.createComment(BaseCommentRequest(context, createIdUser, commentPost))
    }
}