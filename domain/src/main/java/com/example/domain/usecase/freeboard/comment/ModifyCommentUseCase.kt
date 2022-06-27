package com.example.domain.usecase.freeboard.comment

import com.example.domain.repository.freeboard.comment.ModifyCommentRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class ModifyCommentUseCase @Inject constructor(
    private val repository: ModifyCommentRepository
) {
    operator fun invoke(
        context: String,
        createUserId: Int,
        commentPost: Int,
        pk: Int,
        scope: CoroutineScope,
        onResult: (Int?) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                repository.modifyComment(context, createUserId, commentPost, pk)
            }
            onResult(deferred.await())
        }
    }
}