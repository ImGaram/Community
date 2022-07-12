package com.example.data.datasource.story.datasource.comment

import com.example.data.entity.story.response.BaseCommentResponse

interface GetCommentListDataSource {
    suspend fun getCommentList(
        story: Int
    ): List<BaseCommentResponse>?
}