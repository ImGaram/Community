package com.example.data.datasource.story.repository.comment

import com.example.data.datasource.story.datasource.comment.SuggestStoryDataSource
import com.example.data.entity.story.request.SuggestStoryRequest
import com.example.domain.repository.story.comment.SuggestStoryRepository
import javax.inject.Inject

class SuggestStoryRepositoryImpl @Inject constructor(
    private val dataSource: SuggestStoryDataSource
): SuggestStoryRepository {
    override suspend fun suggestStoryLogic(user: Int, board: Int): Int? {
        return dataSource.suggestStory(SuggestStoryRequest(user, board))
    }
}