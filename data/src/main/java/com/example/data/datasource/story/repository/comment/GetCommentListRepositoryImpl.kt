package com.example.data.datasource.story.repository.comment

import com.example.data.datasource.story.datasource.comment.GetCommentListDataSource
import com.example.domain.model.story.DomainBaseCommentResponse
import com.example.domain.repository.story.comment.GetCommentListRepository
import javax.inject.Inject

class GetCommentListRepositoryImpl @Inject constructor(
    private val dataSource: GetCommentListDataSource
): GetCommentListRepository {
    override suspend fun getCommentList(story: Int): List<DomainBaseCommentResponse>? {
        return dataSource.getCommentList(story)
    }
}