package com.example.data.api.inquiry

import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.Path

interface DeleteInquiryService {
    @DELETE("/Inq/{inquiry}")
    suspend fun deleteInquiry(@Path("inquiry") inquiry: Int): Response<Int>
}