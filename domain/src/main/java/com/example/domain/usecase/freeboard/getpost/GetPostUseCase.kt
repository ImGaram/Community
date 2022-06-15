package com.example.domain.usecase.freeboard.getpost

import com.example.domain.model.freeboard.DomainBaseFreeBoardResponse
import com.example.domain.model.freeboard.getpostall.DomainGetAllFreeBoardResponse
import com.example.domain.repository.freeboard.getpost.GetPostRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class GetPostUseCase(
    private val repository: GetPostRepository
) {
    operator fun invoke(
        id: Int,
        scope: CoroutineScope,
        onResult: (DomainBaseFreeBoardResponse?) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                repository.getPostSingle(id)
            }
            onResult(deferred.await())
        }
    }
}