package com.example.community.di.module.network

import com.example.data.ApiClient
import com.example.data.api.inquiry.CreateInquiryService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class InquiryNetWorkModule {
    @Named("createInquiry")
    @Provides
    @Singleton
    fun provideCreateInquiryRetrofitInstance(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiClient.BASE_URL)
            .client(okHttpClient)
            .client(NetWorkModule.provideOkhttpClient())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.createWithScheduler(Schedulers.newThread()))
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun provideCreateInquiryService(@Named("createInquiry") retrofit: Retrofit): CreateInquiryService {
        return retrofit.create(CreateInquiryService::class.java)
    }
}