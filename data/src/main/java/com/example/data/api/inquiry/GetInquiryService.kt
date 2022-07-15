package com.example.data.api.inquiry

import com.example.data.entity.inquiry.response.BaseInquiryResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GetInquiryService {
    @GET("/Inq/{inquiry}")
    suspend fun getInquiry(
        @Path("inquiry") inquiry: Int
    ): Response<BaseInquiryResponse>
}