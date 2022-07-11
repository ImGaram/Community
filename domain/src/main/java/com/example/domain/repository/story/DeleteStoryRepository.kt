package com.example.domain.repository.story

interface DeleteStoryRepository {
    suspend fun deleteStory(
        story: Int
    ): Int?
}