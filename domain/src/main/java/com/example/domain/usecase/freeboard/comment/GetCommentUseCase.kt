package com.example.domain.usecase.freeboard.comment

import com.example.domain.model.freeboard.comment.DomainGetCommentResponse
import com.example.domain.repository.freeboard.comment.GetCommentRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class GetCommentUseCase @Inject constructor(
    private val repository: GetCommentRepository
) {
    operator fun invoke(
        postId: Int,
        scope: CoroutineScope,
        onResult: (List<DomainGetCommentResponse>?) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                repository.getComment(postId)
            }
            onResult(deferred.await())
        }
    }
}