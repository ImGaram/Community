package com.example.data.api

import com.example.data.entity.request.SignInRequest
import com.example.data.entity.response.SignInResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface NbService {
    @POST("/User/")
    fun signInService(@Body signInRequest: SignInRequest): Single<SignInResponse>
}