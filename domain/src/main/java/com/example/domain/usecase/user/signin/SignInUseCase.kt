package com.example.domain.usecase.user.signin

import com.example.domain.model.user.DomainSignInResponse
import com.example.domain.repository.user.signin.SignInRepository
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