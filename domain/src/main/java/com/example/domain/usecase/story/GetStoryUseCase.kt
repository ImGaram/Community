package com.example.domain.usecase.story

import com.example.domain.model.story.DomainBaseStoryResponse
import com.example.domain.repository.story.GetStoryRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class GetStoryUseCase @Inject constructor(
    private val repository: GetStoryRepository
) {
    operator fun invoke(
        scope: CoroutineScope,
        onResult: (List<DomainBaseStoryResponse>?) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                repository.getStory()
            }
            onResult(deferred.await())
        }
    }
}