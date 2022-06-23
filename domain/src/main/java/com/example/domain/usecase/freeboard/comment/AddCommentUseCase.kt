package com.example.domain.usecase.freeboard.comment

import com.example.domain.repository.freeboard.comment.AddCommentRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddCommentUseCase @Inject constructor(
    private val repository: AddCommentRepository
) {
    operator fun invoke(
        context: String,
        createUserId: Int,
        commentPost: Int,
        scope: CoroutineScope,
        onResult: (Int?) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                repository.createComment(context, createUserId, commentPost)
            }
            onResult(deferred.await())
        }
    }
}