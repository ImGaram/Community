package com.example.data.datasource.story.repository

import com.example.data.datasource.story.datasource.DeleteStoryDataSource
import com.example.domain.repository.story.DeleteStoryRepository
import javax.inject.Inject

class DeleteStoryRepositoryImpl @Inject constructor(
    private val dataSource: DeleteStoryDataSource
): DeleteStoryRepository {
    override suspend fun deleteStory(story: Int): Int? {
        return dataSource.deleteStory(story)
    }
}