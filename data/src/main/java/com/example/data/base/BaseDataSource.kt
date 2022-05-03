package com.example.data.base

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

// RE에 remote를 넣어준다.
abstract class BaseDataSource<RE> {
    abstract val service: RE

    suspend inline fun <T> safeApiCall(crossinline callFunction: suspend () -> T): T? {
        return try {
            val myObj = withContext(Dispatchers.IO) { callFunction.invoke() }
            myObj
        } catch (e: Exception) {
            withContext(Dispatchers.Main) {
                e.printStackTrace()
                Log.e("ERROR", "Call error: ${e.localizedMessage}", e.cause)
                when(e) {
                    is HttpException -> {
                        if (e.code() == 400) {
                            Log.e("ERROR", "400ERROR", e.cause)
                        } else {
                            val body = e.response()?.errorBody()
                            Log.e("ERROR", "another error $body")
                        }
                    }
                    is SocketTimeoutException -> Log.e("ERROR", "timeout error")
                    is IOException -> Log.e("ERROR", "network error")
                    else -> Log.e("ERROR", "알수 없는 오류")
                }
            }
            null
        }
    }
}