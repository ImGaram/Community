package com.example.domain.usecase.freeboard.delete

import com.example.domain.repository.freeboard.delete.DeletePostRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class DeletePostUseCase @Inject constructor(
    private val repository: DeletePostRepository
) {
    operator fun invoke(
        pk: Int,
        scope: CoroutineScope,
        onResult: (Int) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                repository.deletePost(pk)
            }
            onResult(deferred.await())
        }
    }
}