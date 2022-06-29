package com.example.domain.usecase.freeboard.comment

import com.example.domain.repository.freeboard.suggest.GetSuggestRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class GetSuggestPostUseCase @Inject constructor(
    private val repository: GetSuggestRepository
) {
    operator fun invoke(
        board: Int,
        scope: CoroutineScope,
        onResult: (Int?) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                repository.getSuggest(board)
            }
            onResult(deferred.await())
        }
    }
}