package com.example.domain.usecase.user.login

import com.example.domain.model.user.DomainLoginResponse
import com.example.domain.repository.user.login.LoginRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class LoginUseCase(
    private val repository: LoginRepository
) {
    operator fun invoke(
        email: String,
        password: String,
        scope: CoroutineScope,
        onResult: (DomainLoginResponse?) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                repository.login(email, password)
            }
            onResult(deferred.await())
        }
    }
}