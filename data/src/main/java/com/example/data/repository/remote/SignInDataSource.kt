package com.example.data.repository.remote

import com.example.data.base.BaseSignInResponse
import com.example.data.entity.request.SignInRequest
import com.example.data.entity.response.SignInResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Response

interface SignInDataSource {
    suspend fun signUp(request: SignInRequest): Single<SignInResponse>
}