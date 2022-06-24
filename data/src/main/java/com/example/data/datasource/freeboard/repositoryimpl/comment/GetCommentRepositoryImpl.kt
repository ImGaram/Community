package com.example.data.datasource.freeboard.repositoryimpl.comment

import com.example.data.datasource.freeboard.remote.comment.GetCommentDataSource
import com.example.domain.model.freeboard.comment.DomainGetCommentResponse
import com.example.domain.repository.freeboard.comment.GetCommentRepository
import javax.inject.Inject

class GetCommentRepositoryImpl @Inject constructor(
    private val dataSource: GetCommentDataSource
): GetCommentRepository {
    override suspend fun getComment(
        id: Int
    ): List<DomainGetCommentResponse>? {
        return dataSource.getComment(id)
    }
}