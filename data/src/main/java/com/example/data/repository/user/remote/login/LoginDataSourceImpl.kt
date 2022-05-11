package com.example.data.repository.user.remote.login

import com.example.data.api.NbLoginService
import com.example.data.base.BaseDataSource
import com.example.data.entity.user.request.LoginRequest
import com.example.data.entity.user.response.LoginResponse
import javax.inject.Inject

class LoginDataSourceImpl @Inject constructor(
    override val service: NbLoginService
) : BaseDataSource<NbLoginService>(), LoginDataSource{
    override suspend fun login(
        user: LoginRequest
    ): LoginResponse? {
        return safeApiCall {
            service.loginService(user)
        }?.body()
    }
}