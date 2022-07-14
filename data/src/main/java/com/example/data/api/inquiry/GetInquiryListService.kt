package com.example.data.api.inquiry

import com.example.data.entity.inquiry.response.BaseInquiryResponse
import retrofit2.Response
import retrofit2.http.GET

interface GetInquiryListService {
    @GET("/Inq/")
    suspend fun getInquiryList(): Response<List<BaseInquiryResponse>>
}