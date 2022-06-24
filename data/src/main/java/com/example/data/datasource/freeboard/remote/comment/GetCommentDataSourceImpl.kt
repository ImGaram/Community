package com.example.data.datasource.freeboard.remote.comment

import com.example.data.api.freeboard.GetCommentService
import com.example.data.base.BaseDataSource
import com.example.data.entity.freeboard.response.GetCommentResponse
import javax.inject.Inject

class GetCommentDataSourceImpl @Inject constructor(
    override val service: GetCommentService
): BaseDataSource<GetCommentService>(), GetCommentDataSource {
    override suspend fun getComment(postId: Int): List<GetCommentResponse>? {
        return safeApiCall {
            service.getComment(postId)
        }?.body()
    }
}