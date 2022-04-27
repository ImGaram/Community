package com.example.data.repository

import com.example.data.entity.request.SignInRequest
import com.example.data.mapper.SignInMapper
import com.example.data.mapper.SignInMapper.toDomain
import com.example.data.repository.remote.SignInDataSourceImpl
import com.example.domain.model.DomainSignInResponse
import com.example.domain.repository.SignInRepository
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import javax.inject.Inject

class SignInRepositoryImpl @Inject constructor(
    private val dataSourceImpl: SignInDataSourceImpl
): SignInRepository {
    override suspend fun signUp(
        name: String,
        email: String,
        password: String
    ): Single<DomainSignInResponse> {
        return dataSourceImpl.signUp(SignInRequest(name, email, password)).map { it.toDomain() }
    }
}