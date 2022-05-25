package com.example.data.repository.user.remote.delete

interface DeleteUserDataSource {
    suspend fun delete(
        pk: Int
    ): Int?
}