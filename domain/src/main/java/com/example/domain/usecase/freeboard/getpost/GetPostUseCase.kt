package com.example.domain.usecase.freeboard.getpost

import com.example.domain.model.freeboard.getpost.DomainGetFreeBoardResponse
import com.example.domain.repository.freeboard.getpost.GetPostRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import okhttp3.ResponseBody

class GetPostUseCase(
    private val repository: GetPostRepository
) {
    operator fun invoke(
        scope: CoroutineScope,
        onResult: (List<DomainGetFreeBoardResponse>?) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                repository.getPost()
            }
            onResult(deferred.await())
        }
    }
}