package com.example.domain.repository.story.comment

interface GetSuggestRepository {
    suspend fun getSuggest(
        story: Int
    ): Int?
}