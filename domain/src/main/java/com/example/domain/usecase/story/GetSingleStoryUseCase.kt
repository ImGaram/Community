package com.example.domain.usecase.story

import com.example.domain.model.story.DomainBaseStoryResponse
import com.example.domain.repository.story.GetStorySingleRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class GetSingleStoryUseCase @Inject constructor(
    private val repository: GetStorySingleRepository
) {
    operator fun invoke(
        storyId: Int,
        scope: CoroutineScope,
        onResult: (DomainBaseStoryResponse?) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async (Dispatchers.IO){
                repository.getSingleStory(storyId)
            }
            onResult(deferred.await())
        }
    }
}