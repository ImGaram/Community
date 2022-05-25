package com.example.domain.repository.user.delete

import okhttp3.ResponseBody

interface DeleteUserRepository {
    suspend fun delete(
        pk: Int
    ): ResponseBody?
}