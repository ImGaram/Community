package com.example.domain.usecase.freeboard.modify

import com.example.domain.model.freeboard.DomainBaseFreeBoardResponse
import com.example.domain.repository.freeboard.modify.ModifyPostRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class ModifyPostUseCase(
    private val repository: ModifyPostRepository
) {
    operator fun invoke(
        title: String,
        context:String,
        img1:String,
        img2:String,
        img3:String,
        img4:String,
        img5:String,
        createUser: Int,
        id: Int,
        scope: CoroutineScope,
        onResult: (DomainBaseFreeBoardResponse?) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                repository.modifyPost(title, context, img1, img2, img3, img4, img5, createUser, id)
            }
            onResult(deferred.await())
        }
    }
}