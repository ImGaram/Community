package com.example.data.repository.user.remote.userinfo

import com.example.data.api.NbUserInfoService
import com.example.data.base.BaseDataSource
import com.example.data.entity.user.response.UserInfoResponse
import javax.inject.Inject

class UserInfoDataSourceImpl @Inject constructor(
    override val service: NbUserInfoService
): BaseDataSource<NbUserInfoService>(), UserInfoDataSource {
    override suspend fun getUserInfo(
        userId: Int
    ): UserInfoResponse? {
        return safeApiCall {
            service.getUser(userId)
        }?.body()
    }
}