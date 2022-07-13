package com.example.data.datasource.story.datasource.comment

import com.example.data.entity.story.request.SuggestStoryRequest

interface SuggestStoryDataSource {
    suspend fun suggestStory(
        body: SuggestStoryRequest
    ): Int?
}