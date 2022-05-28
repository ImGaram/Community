package com.example.data.datasource.user.remote.delete

import okhttp3.ResponseBody

interface DeleteUserDataSource {
    suspend fun delete(
        pk: Int
    ): ResponseBody?
}