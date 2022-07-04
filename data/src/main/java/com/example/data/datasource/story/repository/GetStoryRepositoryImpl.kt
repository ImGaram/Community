package com.example.data.datasource.story.repository

import com.example.data.datasource.story.datasource.GetStoryDataSource
import com.example.domain.model.story.DomainBaseStoryResponse
import com.example.domain.repository.story.GetStoryRepository
import javax.inject.Inject

class GetStoryRepositoryImpl @Inject constructor(
    private val dataSource: GetStoryDataSource
): GetStoryRepository {
    override suspend fun getStory(): List<DomainBaseStoryResponse>? {
        return dataSource.getStory()
    }
}