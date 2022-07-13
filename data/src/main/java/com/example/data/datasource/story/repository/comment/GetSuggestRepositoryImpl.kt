package com.example.data.datasource.story.repository.comment

import com.example.data.datasource.story.datasource.comment.GetSuggestDataSource
import com.example.domain.repository.story.comment.GetSuggestRepository
import javax.inject.Inject

class GetSuggestRepositoryImpl @Inject constructor(
    private val dataSource: GetSuggestDataSource
): GetSuggestRepository {
    override suspend fun getSuggest(story: Int): Int? {
        return dataSource.getSuggest(story)
    }
}