package com.example.data.datasource.story.datasource

import com.example.data.entity.story.request.CreateStoryRequest
import com.example.data.entity.story.response.BaseStoryResponse

interface CreateStoryDataSource {
    suspend fun createStory(
        body: CreateStoryRequest
    ): BaseStoryResponse?
}