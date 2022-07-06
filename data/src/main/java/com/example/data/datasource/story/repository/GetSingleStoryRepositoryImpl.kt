package com.example.data.datasource.story.repository

import com.example.data.datasource.story.datasource.GetStorySingleDataSource
import com.example.domain.model.story.DomainBaseStoryResponse
import com.example.domain.repository.story.GetStorySingleRepository
import javax.inject.Inject

class GetSingleStoryRepositoryImpl @Inject constructor(
    private val dataSource: GetStorySingleDataSource
): GetStorySingleRepository {
    override suspend fun getSingleStory(storyId: Int): DomainBaseStoryResponse? {
        return dataSource.getSingleStory(storyId)
    }
}