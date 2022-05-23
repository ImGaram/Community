package com.example.presentation.di.module

import android.util.Log
import com.example.data.ApiClient
import com.example.data.api.NbJoinService
import com.example.data.api.NbLoginService
import com.example.data.api.NbUserInfoService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetWorkModule {

    private const val BASE_URL = ApiClient.BASE_URL

    @Provides
    @Singleton
    fun provideOkhttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            // 요청을 시작한 후 서버와의 TCP handshake 가 완료되기까지 지속되는 시간
            .connectTimeout(30, TimeUnit.SECONDS)
            // 모든 바이트가 전송되는 속도륵 감시
            .readTimeout(30, TimeUnit.SECONDS)
            // 읽기 타임 아웃의 반대 방향. 얼마나 빨리 서버에 바이트를 보낼 수 있는지 확인
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    @Named("signin")
    @Provides
    @Singleton
    fun provideSignInRetrofitInstance(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .client(provideOkhttpClient())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Named("login")
    @Provides
    @Singleton
    fun provideLoginRetrofitInstance(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .client(provideOkhttpClient())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.createWithScheduler(Schedulers.newThread()))
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Named("userinfo")
    @Provides
    @Singleton
    fun provideUserInfoRetrofitInstance(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .client(provideOkhttpClient())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.createWithScheduler(Schedulers.newThread()))
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun provideConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun provideJoinService(@Named("signin") retrofit: Retrofit): NbJoinService {
        return retrofit.create(NbJoinService::class.java)
    }

    @Provides
    @Singleton
    fun provideLoginService(@Named("login") retrofit: Retrofit): NbLoginService {
        return retrofit.create(NbLoginService::class.java)
    }

    @Provides
    @Singleton
    fun provideUserInfoService(@Named("userinfo") retrofit: Retrofit): NbUserInfoService {
        return retrofit.create(NbUserInfoService::class.java)
    }
}