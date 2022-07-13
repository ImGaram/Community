package com.example.domain.repository.story.comment

interface SuggestStoryRepository {
    suspend fun suggestStoryLogic(
        user: Int,
        board: Int
    ): Int?
}