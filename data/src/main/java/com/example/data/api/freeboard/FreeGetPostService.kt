package com.example.data.api.freeboard

import com.example.data.entity.freeboard.response.AddFreeBoardResponse
import okhttp3.ResponseBody
import org.json.JSONArray
import retrofit2.Response
import retrofit2.http.GET

interface FreeGetPostService {
    @GET("/FBN/")
    suspend fun getPost(): List<AddFreeBoardResponse>
}