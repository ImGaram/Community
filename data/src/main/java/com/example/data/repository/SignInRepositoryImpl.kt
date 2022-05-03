package com.example.data.repository

import com.example.data.entity.request.SignInRequest
import com.example.data.mapper.SignInMapper
import com.example.data.repository.remote.SignInDataSource
import com.example.domain.model.DomainSignInResponse
import com.example.domain.repository.SignInRepository
import javax.inject.Inject

class SignInRepositoryImpl @Inject constructor(
    private val dataSourceImpl: SignInDataSource
): SignInRepository {
    override suspend fun signUp(
        name: String,
        email: String,
        password: String
    ): DomainSignInResponse? {
        return SignInMapper.toDomainResponse(dataSourceImpl.signUp(SignInRequest(name, email, password)))
    }
}