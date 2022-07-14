package com.example.data.api.inquiry

import com.example.data.entity.inquiry.request.BaseInquiryRequest
import com.example.data.entity.inquiry.response.BaseInquiryResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface CreateInquiryService {
    @POST("/Inq/CRE/")
    suspend fun createInquiry(
        @Body boy: BaseInquiryRequest
    ): Response<BaseInquiryResponse>
}