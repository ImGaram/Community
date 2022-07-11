package com.example.data.datasource.story.datasource

import com.example.data.api.story.ModifyStoryService
import com.example.data.base.BaseDataSource
import com.example.data.entity.story.request.CreateStoryRequest
import com.example.data.entity.story.response.BaseStoryResponse
import javax.inject.Inject

class ModifyStoryDataSourceImpl @Inject constructor(
    override val service: ModifyStoryService
): BaseDataSource<ModifyStoryService>(), ModifyStoryDataSource{
    override suspend fun modifyStory(
        story: Int,
        body: CreateStoryRequest
    ): BaseStoryResponse? {
        return safeApiCall {
            service.modifyStory(story, body)
        }?.body()
    }
}