package com.example.domain.usecase.freeboard.comment

import com.example.domain.repository.freeboard.suggest.SuggestPostRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class SuggestPostUseCase @Inject constructor(
    private val repository: SuggestPostRepository
) {
    operator fun invoke(
        user: Int,
        board: Int,
        scope: CoroutineScope,
        onResult: (Int?) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                repository.suggestPost(user, board)
            }
            onResult(deferred.await())
        }
    }
}