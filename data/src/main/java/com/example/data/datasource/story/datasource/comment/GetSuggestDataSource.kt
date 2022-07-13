package com.example.data.datasource.story.datasource.comment

interface GetSuggestDataSource {
    suspend fun getSuggest(
        story: Int
    ): Int?
}