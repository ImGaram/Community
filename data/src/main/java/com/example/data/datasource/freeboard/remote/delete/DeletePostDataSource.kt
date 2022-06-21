package com.example.data.datasource.freeboard.remote.delete

interface DeletePostDataSource {
    suspend fun deletePost(
        pk: Int
    ): Int
}