package com.example.domain.repository.user.login

import com.example.domain.model.user.DomainLoginResponse

interface LoginRepository {
    suspend fun login(
        email: String,
        password: String
    ): DomainLoginResponse?
}