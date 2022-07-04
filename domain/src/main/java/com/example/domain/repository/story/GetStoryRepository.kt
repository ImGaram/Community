package com.example.domain.repository.story

import com.example.domain.model.story.DomainBaseStoryResponse

interface GetStoryRepository {
    suspend fun getStory(): List<DomainBaseStoryResponse>?
}