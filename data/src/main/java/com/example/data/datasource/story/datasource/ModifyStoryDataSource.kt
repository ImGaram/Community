package com.example.data.datasource.story.datasource

import com.example.data.entity.story.request.CreateStoryRequest
import com.example.data.entity.story.response.BaseStoryResponse

interface ModifyStoryDataSource {
    suspend fun modifyStory(
        story: Int,
        body: CreateStoryRequest
    ): BaseStoryResponse?
}