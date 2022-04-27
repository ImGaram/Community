package com.example.data.repository.remote

import com.example.data.base.BaseDataSource
import com.example.data.api.NbService
import com.example.data.base.BaseSignInResponse
import com.example.data.entity.request.SignInRequest
import com.example.data.entity.response.SignInResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import javax.inject.Inject

class SignInDataSourceImpl @Inject constructor(override val service: NbService)
    : BaseDataSource<NbService>(), SignInDataSource {
    override suspend fun signUp(
        request: SignInRequest
    ): Single<SignInResponse> {
        return service.signInService(request)
    }
}