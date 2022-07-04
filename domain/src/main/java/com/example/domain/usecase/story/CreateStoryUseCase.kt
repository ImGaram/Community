package com.example.domain.usecase.story

import com.example.domain.model.story.DomainBaseStoryResponse
import com.example.domain.repository.story.CreateStoryRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class CreateStoryUseCase @Inject constructor(
    private val repository: CreateStoryRepository
) {
    operator fun invoke(
        title: String,
        context: String,
        createUser: Int,
        scope: CoroutineScope,
        onResult: (DomainBaseStoryResponse?) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                repository.createStory(title, context, createUser)
            }
            onResult(deferred.await())
        }
    }
}