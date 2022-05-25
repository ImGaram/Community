package com.example.data.repository.user.remote.delete

import okhttp3.ResponseBody

interface DeleteUserDataSource {
    suspend fun delete(
        pk: Int
    ): ResponseBody?
}