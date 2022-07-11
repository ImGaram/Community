package com.example.domain.repository.story

import com.example.domain.model.story.DomainBaseStoryResponse

interface ModifyStoryRepository {
    suspend fun modifyStory(
        story: Int,
        title: String,
        context: String,
        createUser: Int
    ): DomainBaseStoryResponse?
}