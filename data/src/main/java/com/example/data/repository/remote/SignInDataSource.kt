package com.example.data.repository.remote

import com.example.data.entity.request.SignInRequest
import com.example.data.entity.response.SignInResponse

interface SignInDataSource {
    suspend fun signUp(
        body: SignInRequest
    ): SignInResponse?
}