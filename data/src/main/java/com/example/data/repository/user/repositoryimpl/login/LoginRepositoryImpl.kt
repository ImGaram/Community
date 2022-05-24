package com.example.data.repository.user.repositoryimpl.login

import com.example.data.entity.user.request.LoginRequest
import com.example.data.mapper.Mapper
import com.example.data.repository.user.remote.login.LoginDataSource
import com.example.domain.model.user.DomainLoginResponse
import com.example.domain.repository.user.login.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val dataSource: LoginDataSource
): LoginRepository {
    override suspend fun login(
        email: String,
        password: String
    ): DomainLoginResponse? {
        return Mapper.toDomainLogInResponse(dataSource.login(LoginRequest(email, password)))
    }
}