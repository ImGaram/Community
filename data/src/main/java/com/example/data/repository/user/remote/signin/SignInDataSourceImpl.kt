package com.example.data.repository.user.remote.signin

import com.example.data.ApiClient
import com.example.data.api.NbJoinService
import com.example.data.base.BaseDataSource
import com.example.data.entity.user.request.SignInRequest
import com.example.data.entity.user.response.SignInResponse
import javax.inject.Inject

class SignInDataSourceImpl @Inject constructor(
    override val service: NbJoinService
): BaseDataSource<NbJoinService>(), SignInDataSource {
    override suspend fun signUp(
        body: SignInRequest
    ): SignInResponse? {
        return safeApiCall {
            service.signInService(body)
        }?.body()
    }
}