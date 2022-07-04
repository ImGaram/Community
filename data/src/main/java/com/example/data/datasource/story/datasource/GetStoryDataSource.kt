package com.example.data.datasource.story.datasource

import com.example.data.entity.story.response.BaseStoryResponse

interface GetStoryDataSource {
    suspend fun getStory(): List<BaseStoryResponse>?
}