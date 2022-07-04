package com.example.data.datasource.story.datasource

import com.example.data.api.story.CreateStoryService
import com.example.data.base.BaseDataSource
import com.example.data.entity.story.request.CreateStoryRequest
import com.example.data.entity.story.response.BaseStoryResponse
import javax.inject.Inject

class CreateStoryDataSourceImpl @Inject constructor(
    override val service: CreateStoryService
): BaseDataSource<CreateStoryService>(), CreateStoryDataSource {
    override suspend fun createStory(body: CreateStoryRequest): BaseStoryResponse? {
        return safeApiCall {
            service.createStory(body)
        }?.body()
    }
}