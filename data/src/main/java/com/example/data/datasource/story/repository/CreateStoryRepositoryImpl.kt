package com.example.data.datasource.story.repository

import com.example.data.datasource.story.datasource.CreateStoryDataSource
import com.example.data.entity.story.request.CreateStoryRequest
import com.example.domain.model.story.DomainBaseStoryResponse
import com.example.domain.repository.story.CreateStoryRepository
import javax.inject.Inject

class CreateStoryRepositoryImpl @Inject constructor(
    private val dataSource: CreateStoryDataSource
): CreateStoryRepository {
    override suspend fun createStory(
        title: String,
        context: String,
        createUser: Int
    ): DomainBaseStoryResponse? {
        return dataSource.createStory(CreateStoryRequest(title, context, createUser))
    }
}