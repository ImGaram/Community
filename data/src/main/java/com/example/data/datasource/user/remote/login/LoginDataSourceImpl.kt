package com.example.data.datasource.user.remote.login

import android.util.Log
import com.example.data.ApiClient
import com.example.data.api.user.NbLoginService
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
        val serviceCall = service.loginService(user)
        ApiClient.resultCode = serviceCall.code()
        Log.d("SUCCESS", "login api result code: ${ApiClient.resultCode}")
        return safeApiCall {
            serviceCall
        }?.body()
    }
}