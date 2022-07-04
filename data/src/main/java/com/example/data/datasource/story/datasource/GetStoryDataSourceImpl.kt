package com.example.data.datasource.story.datasource

import com.example.data.api.story.GetStoryService
import com.example.data.base.BaseDataSource
import com.example.data.entity.story.response.BaseStoryResponse
import javax.inject.Inject

class GetStoryDataSourceImpl @Inject constructor(
    override val service: GetStoryService
): BaseDataSource<GetStoryService>(), GetStoryDataSource {
    override suspend fun getStory(): List<BaseStoryResponse>? {
        return safeApiCall {
            service.getStory()
        }?.body()
    }
}