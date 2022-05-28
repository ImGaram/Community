package com.example.domain.usecase.user.delete

import com.example.domain.repository.user.delete.DeleteUserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import okhttp3.ResponseBody

class DeleteUserUseCase(
    private val repository: DeleteUserRepository
) {
    operator fun invoke(
        pk: Int,
        scpoe: CoroutineScope,
        onResult: (ResponseBody?) -> Unit = {}
    ) {
        scpoe.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                repository.delete(pk)
            }
            onResult(deferred.await())
        }
    }
}