package com.example.domain.usecase.story

import com.example.domain.model.story.DomainBaseStoryResponse
import com.example.domain.repository.story.ModifyStoryRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class ModifyStoryUseCase @Inject constructor(
    private val repository: ModifyStoryRepository
) {
    operator fun invoke(
        story: Int,
        title: String,
        context: String,
        createUser: Int,
        scope: CoroutineScope,
        onResult: (DomainBaseStoryResponse?) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                repository.modifyStory(story, title, context, createUser)
            }
            onResult(deferred.await())
        }
    }
}