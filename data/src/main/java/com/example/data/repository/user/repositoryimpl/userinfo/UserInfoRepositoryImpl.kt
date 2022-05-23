package com.example.data.repository.user.repositoryimpl.userinfo

import com.example.data.mapper.Mapper
import com.example.data.repository.user.remote.userinfo.UserInfoDataSource
import com.example.domain.model.user.DomainUserInfoResponse
import com.example.domain.repository.user.userinfo.UserInfoRepository
import javax.inject.Inject

class UserInfoRepositoryImpl @Inject constructor(
    private val dataSource: UserInfoDataSource
): UserInfoRepository {
    override suspend fun getUserInfo(
        id: Int
    ): DomainUserInfoResponse? {
        return Mapper.toDomainUserInfoResponse(dataSource.getUserInfo(id))
    }
}