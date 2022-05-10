package com.example.data.repository.user.repositoryimpl.signin

import com.example.data.entity.user.request.SignInRequest
import com.example.data.mapper.Mapper
import com.example.data.repository.user.remote.signin.SignInDataSource
import com.example.domain.model.user.DomainSignInResponse
import com.example.domain.repository.user.signin.SignInRepository
import javax.inject.Inject

class SignInRepositoryImpl @Inject constructor(
    private val dataSource: SignInDataSource
): SignInRepository {
    override suspend fun signUp(
        name: String,
        email: String,
        password: String
    ): DomainSignInResponse? {
        return Mapper.toDomainSignInResponse(dataSource.signUp(SignInRequest(name, email, password)))
    }
}