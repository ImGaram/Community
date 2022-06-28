package com.example.data.datasource.freeboard.repositoryimpl.comment

import com.example.data.datasource.freeboard.remote.comment.DeleteCommentDataSource
import com.example.domain.repository.freeboard.comment.DeleteCommentRepository
import javax.inject.Inject

class DeleteCommentRepositoryImpl @Inject constructor(
    private val dataSource: DeleteCommentDataSource
): DeleteCommentRepository {
    override suspend fun deleteComment(postId: Int): Int? {
        return dataSource.deleteComment(postId)
    }
}