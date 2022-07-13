package com.example.data.datasource.story.datasource.comment

import com.example.data.api.story.comment.SuggestStoryService
import com.example.data.base.BaseDataSource
import com.example.data.entity.story.request.SuggestStoryRequest
import javax.inject.Inject

class SuggestStoryDataSourceImpl @Inject constructor(
    override val service: SuggestStoryService
): BaseDataSource<SuggestStoryService>(), SuggestStoryDataSource {
    override suspend fun suggestStory(body: SuggestStoryRequest): Int? {
        return safeApiCall {
            service.suggestStory(body)
        }?.code()
    }
}