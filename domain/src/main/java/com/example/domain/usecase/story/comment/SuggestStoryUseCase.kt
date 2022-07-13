package com.example.domain.usecase.story.comment

import com.example.domain.repository.story.comment.SuggestStoryRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class SuggestStoryUseCase @Inject constructor(
    private val repository: SuggestStoryRepository
) {
    operator fun invoke(
        user: Int,
        board: Int,
        scope: CoroutineScope,
        onResult: (Int?) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                repository.suggestStoryLogic(user, board)
            }
            onResult(deferred.await())
        }
    }
}