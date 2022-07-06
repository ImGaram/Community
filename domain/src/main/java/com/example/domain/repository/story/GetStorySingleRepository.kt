package com.example.domain.repository.story

import com.example.domain.model.story.DomainBaseStoryResponse

interface GetStorySingleRepository {
    suspend fun getSingleStory(
        storyId: Int
    ): DomainBaseStoryResponse?
}