package com.example.data.datasource.story.datasource.comment

import com.example.data.api.story.comment.CreateStoryCommentService
import com.example.data.base.BaseDataSource
import com.example.data.entity.story.request.CreateCommentRequest
import com.example.data.entity.story.response.BaseCommentResponse
import javax.inject.Inject

class CreateCommentDataSourceImpl @Inject constructor(
    override val service: CreateStoryCommentService
): BaseDataSource<CreateStoryCommentService>(), CreateCommentDataSource {
    override suspend fun createComment(body: CreateCommentRequest): BaseCommentResponse? {
        return safeApiCall {
            service.createStoryComment(body)
        }?.body()
    }
}