package com.example.data.datasource.story.datasource

interface DeleteStoryDataSource {
    suspend fun deleteStory(
        postId: Int
    ): Int?
}