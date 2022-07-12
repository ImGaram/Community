package com.example.data.datasource.story.datasource.comment

import com.example.data.api.story.comment.GetCommentListService
import com.example.data.base.BaseDataSource
import com.example.data.entity.story.response.BaseCommentResponse
import javax.inject.Inject

class GetCommentListDataSourceImpl @Inject constructor(
    override val service: GetCommentListService
): BaseDataSource<GetCommentListService>(), GetCommentListDataSource {
    override suspend fun getCommentList(story: Int): List<BaseCommentResponse>? {
        return safeApiCall {
            service.getCommentList(story)
        }?.body()
    }
}