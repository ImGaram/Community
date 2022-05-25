package com.example.domain.repository.user.delete

interface DeleteUserRepository {
    suspend fun delete(
        pk: Int
    ): Int?
}