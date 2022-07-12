package com.example.domain.usecase.story.comment

import com.example.domain.model.story.DomainBaseCommentResponse
import com.example.domain.repository.story.comment.GetCommentListRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class GetCommentListUseCase @Inject constructor(
    private val repository: GetCommentListRepository
) {
    operator fun invoke(
        story: Int,
        scope: CoroutineScope,
        onResult: (List<DomainBaseCommentResponse>?) ->  Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                repository.getCommentList(story)
            }
            onResult(deferred.await())
        }
    }
}