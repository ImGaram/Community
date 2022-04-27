package com.example.domain.usecase

import com.example.domain.ParamsUseCase
import com.example.domain.model.DomainSignInResponse
import com.example.domain.repository.SignInRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class SignInUseCase @Inject constructor(private val repository: SignInRepository)
    : ParamsUseCase<SignInUseCase.Params, Single<DomainSignInResponse>>() {

    override suspend fun buildUseCaseObservable(params: Params): Single<DomainSignInResponse> {
        return repository.signUp(
            name = params.name,
            email = params.email,
            password = params.password
        )
    }

    data class Params(
        val name: String,
        val email: String,
        val password: String
    )
}