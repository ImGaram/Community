package com.example.domain.usecase.story.comment

import com.example.domain.model.story.DomainCommentResponse
import com.example.domain.repository.story.comment.CreateCommentRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class CreateCommentUseCase @Inject constructor(
    private val repository: CreateCommentRepository
) {
    operator fun invoke(
        context: String,
        createIdUserSt: Int,
        commentStory: Int,
        scope: CoroutineScope,
        onResult: (DomainCommentResponse?) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                repository.createComment(context, createIdUserSt, commentStory)
            }
            onResult(deferred.await())
        }
    }
}