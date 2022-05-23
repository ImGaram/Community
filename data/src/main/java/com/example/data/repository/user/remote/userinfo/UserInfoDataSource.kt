package com.example.data.repository.user.remote.userinfo

import com.example.data.entity.user.response.UserInfoResponse

interface UserInfoDataSource {
    suspend fun getUserInfo(
        id: Int
    ): UserInfoResponse?
}