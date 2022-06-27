package com.example.data.datasource.freeboard.repositoryimpl.comment

import com.example.data.datasource.freeboard.remote.comment.ModifyCommentDataSource
import com.example.data.entity.freeboard.request.BaseCommentRequest
import com.example.domain.repository.freeboard.comment.ModifyCommentRepository
import javax.inject.Inject

class ModifyCommentRepositoryImpl @Inject constructor(
    private val dataSource: ModifyCommentDataSource
): ModifyCommentRepository{
    override suspend fun modifyComment(
        context: String,
        createIdUser: Int,
        commentPost: Int,
        pk: Int
    ): Int? {
        return dataSource.modifyComment(pk, BaseCommentRequest(context, createIdUser, commentPost))
    }
}