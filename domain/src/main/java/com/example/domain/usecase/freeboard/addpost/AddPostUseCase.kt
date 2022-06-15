package com.example.domain.usecase.freeboard.addpost

import com.example.domain.model.freeboard.DomainBaseFreeBoardResponse
import com.example.domain.repository.freeboard.addpost.AddPostRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class AddPostUseCase(
    private val repository: AddPostRepository
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
        scope: CoroutineScope,
        onResult: (DomainBaseFreeBoardResponse?) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                repository.createPost(title, context, img1, img2, img3, img4, img5, createUser)
            }
            onResult(deferred.await())
        }
    }
}