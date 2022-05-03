package com.example.domain.repository

import com.example.domain.model.DomainSignInResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Response

interface SignInRepository {
    suspend fun signUp(
        // 요청값들
        name: String,
        email: String,
        password: String
    ): DomainSignInResponse?
}