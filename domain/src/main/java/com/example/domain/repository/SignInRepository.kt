package com.example.domain.repository

import com.example.domain.model.DomainSignInResponse

interface SignInRepository {
    suspend fun signUp(
        // 요청값들
        name: String,
        email: String,
        password: String
    ): DomainSignInResponse?
}