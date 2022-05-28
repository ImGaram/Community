package com.example.data.datasource.user.remote.login

import com.example.data.entity.user.request.LoginRequest
import com.example.data.entity.user.response.LoginResponse

interface LoginDataSource {
    suspend fun login(
        user: LoginRequest
    ): LoginResponse?
}