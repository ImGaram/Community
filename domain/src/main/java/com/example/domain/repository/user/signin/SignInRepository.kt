package com.example.domain.repository.user.signin

import com.example.domain.model.user.DomainSignInResponse

interface SignInRepository {
    suspend fun signUp(
        // 요청값들
        name: String,
        email: String,
        password: String
    ): DomainSignInResponse?
}