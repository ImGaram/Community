package com.example.domain.repository.user.userinfo

import com.example.domain.model.user.DomainUserInfoResponse

interface UserInfoRepository {
    suspend fun getUserInfo(
        id: Int?
    ): DomainUserInfoResponse?
}