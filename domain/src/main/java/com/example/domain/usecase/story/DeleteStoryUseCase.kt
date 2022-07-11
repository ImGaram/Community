package com.example.domain.usecase.story

import com.example.domain.repository.story.DeleteStoryRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class DeleteStoryUseCase @Inject constructor(
    private val repository: DeleteStoryRepository
) {
    operator fun invoke(
        story: Int,
        scope: CoroutineScope,
        onResult: (Int?) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                repository.deleteStory(story)
            }
            onResult(deferred.await())
        }
    }
}