package com.example.data.api.inquiry

import com.example.data.entity.inquiry.request.BaseInquiryRequest
import com.example.data.entity.inquiry.response.BaseInquiryResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.PUT
import retrofit2.http.Path

interface ModifyInquiryService {
    @PUT("/Inq/{inquiry}")
    suspend fun modifyInquiry(
        @Path("inquiry") inquiry: Int,
        @Body body: BaseInquiryRequest
    ): Response<BaseInquiryResponse>
}