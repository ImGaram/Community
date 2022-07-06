package com.example.data.datasource.story.datasource

import com.example.data.api.story.GetStorySingleService
import com.example.data.base.BaseDataSource
import com.example.data.entity.story.response.BaseStoryResponse
import javax.inject.Inject

class GetStorySingleDataSourceImpl @Inject constructor(
    override val service: GetStorySingleService
): BaseDataSource<GetStorySingleService>(), GetStorySingleDataSource {
    override suspend fun getSingleStory(storyId: Int): BaseStoryResponse? {
        return safeApiCall {
            service.getSingleStory(storyId)
        }?.body()
    }
}