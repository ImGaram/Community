package com.example.data.datasource.story.datasource

import com.example.data.entity.story.response.BaseStoryResponse

interface GetStorySingleDataSource {
    suspend fun getSingleStory(
        storyId: Int
    ): BaseStoryResponse?
}