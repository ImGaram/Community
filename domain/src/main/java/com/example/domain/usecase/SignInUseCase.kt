package com.example.domain.usecase

import com.example.domain.model.DomainSignInResponse
import com.example.domain.repository.SignInRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class SignInUseCase (
    private val repository: SignInRepository
) {
    operator fun invoke(
        name: String,
        email: String,
        password: String,
        scope: CoroutineScope,
        onResult: (DomainSignInResponse?) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                repository.signUp(name, email, password)
            }
            onResult(deferred.await())
        }
    }
}