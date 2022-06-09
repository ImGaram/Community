package com.example.domain.usecase.freeboard.getpost

import com.example.domain.model.freeboard.getpost.DomainGetAllFreeBoardResponse
import com.example.domain.repository.freeboard.getpost.GetPostAllRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class GetPostAllUseCase(
    private val repository: GetPostAllRepository
) {
    operator fun invoke(
        scope: CoroutineScope,
        onResult: (List<DomainGetAllFreeBoardResponse>?) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                repository.getPost()
            }
            onResult(deferred.await())
        }
    }
}