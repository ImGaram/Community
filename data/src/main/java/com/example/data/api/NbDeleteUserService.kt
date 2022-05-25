package com.example.data.api

import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.Path

interface NbDeleteUserService {
    @DELETE("/User/{pk}")
    suspend fun deleteUser(@Path("pk") pk: Int): Response<Int>
}