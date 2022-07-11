package com.example.data.datasource.story.repository

import com.example.data.datasource.story.datasource.ModifyStoryDataSource
import com.example.data.entity.story.request.CreateStoryRequest
import com.example.domain.model.story.DomainBaseStoryResponse
import com.example.domain.repository.story.ModifyStoryRepository
import javax.inject.Inject

class ModifyStoryRepositoryImpl @Inject constructor(
    private val dataSource: ModifyStoryDataSource
): ModifyStoryRepository {
    override suspend fun modifyStory(
        story: Int,
        title: String,
        context: String,
        createUser: Int
    ): DomainBaseStoryResponse? {
        return dataSource.modifyStory(story, CreateStoryRequest(title, context, createUser))
    }
}