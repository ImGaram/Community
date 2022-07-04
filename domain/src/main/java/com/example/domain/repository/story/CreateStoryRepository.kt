package com.example.domain.repository.story

import com.example.domain.model.story.DomainBaseStoryResponse

interface CreateStoryRepository {
    suspend fun createStory(
        title: String,
        context: String,
        createUser: Int
    ): DomainBaseStoryResponse?
}