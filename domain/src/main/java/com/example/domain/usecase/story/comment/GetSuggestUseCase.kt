package com.example.domain.usecase.story.comment

import com.example.domain.repository.story.comment.GetSuggestRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class GetSuggestUseCase @Inject constructor(
    private val repository: GetSuggestRepository
) {
    operator fun invoke(
        story: Int,
        scope: CoroutineScope,
        onResult: (Int?) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                repository.getSuggest(story)
            }
            onResult(deferred.await())
        }
    }
}