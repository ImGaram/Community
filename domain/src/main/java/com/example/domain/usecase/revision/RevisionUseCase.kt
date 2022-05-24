package com.example.domain.usecase.revision

import com.example.domain.model.base.DomainBaseResponse
import com.example.domain.repository.user.revision.RevisionRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class RevisionUseCase(
    private val repository: RevisionRepository
) {
    operator fun invoke(
        name: String,
        email: String,
        password: String,
        scope: CoroutineScope,
        onResult: (DomainBaseResponse?) -> Unit = {}
    ){
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                repository.revision(name, email, password)
            }
            onResult(deferred.await())
        }
    }
}