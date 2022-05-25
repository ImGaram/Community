package com.example.domain.usecase.delete

import com.example.domain.repository.user.delete.DeleteUserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class DeleteUserUseCase(
    private val repository: DeleteUserRepository
) {
    operator fun invoke(
        pk: Int,
        scpoe: CoroutineScope,
        onResult: (Int?) -> Unit = {}
    ) {
        scpoe.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                repository.delete(pk)
            }
            onResult(deferred.await())
        }
    }
}