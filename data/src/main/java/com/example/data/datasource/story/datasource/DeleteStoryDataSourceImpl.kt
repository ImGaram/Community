package com.example.data.datasource.story.datasource

import com.example.data.api.story.DeleteStoryService
import com.example.data.base.BaseDataSource
import javax.inject.Inject

class DeleteStoryDataSourceImpl @Inject constructor(
    override val service: DeleteStoryService
): BaseDataSource<DeleteStoryService>(), DeleteStoryDataSource {
    override suspend fun deleteStory(postId: Int): Int? {
        return safeApiCall {
            service.deleteStory(postId)
        }?.code()
    }
}