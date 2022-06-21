package com.example.domain.repository.freeboard.delete

interface DeletePostRepository {
    suspend fun deletePost(
        pk: Int
    ): Int
}