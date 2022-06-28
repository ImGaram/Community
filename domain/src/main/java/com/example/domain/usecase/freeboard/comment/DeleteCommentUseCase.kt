package com.example.domain.usecase.freeboard.comment

import com.example.domain.repository.freeboard.comment.DeleteCommentRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class DeleteCommentUseCase @Inject constructor(
    private val repository: DeleteCommentRepository
) {
    operator fun invoke(
        postId: Int,
        scope: CoroutineScope,
        onResult: (Int?) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                repository.deleteComment(postId)
            }
            onResult(deferred.await())
        }
    }
}