package com.example.domain.usecase.inquiry

import com.example.domain.model.inquiry.DomainBaseInquiryResponse
import com.example.domain.repository.inquiry.CreateInquiryRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class CreateInquiryUseCase @Inject constructor(
    private val repository: CreateInquiryRepository
) {
    operator fun invoke(
        title: String,
        context: String,
        createUserId: Int,
        scope: CoroutineScope,
        onResult: (DomainBaseInquiryResponse?) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                repository.createInquiry(title, context, createUserId)
            }
            onResult(deferred.await())
        }
    }
}