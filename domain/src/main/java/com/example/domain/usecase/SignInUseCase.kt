package com.example.domain.usecase

import com.example.domain.ParamsUseCase
import com.example.domain.model.DomainSignInResponse
import com.example.domain.repository.SignInRepository
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val repository: SignInRepository
) {
    suspend fun buildUseCaseObservable
                (name: String,
                 email: String,
                 password: String) = repository.signUp(name, email, password)
}