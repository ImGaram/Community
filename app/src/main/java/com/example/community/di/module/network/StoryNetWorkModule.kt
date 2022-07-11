package com.example.community.di.module.network

import com.example.data.ApiClient
import com.example.data.api.story.CreateStoryService
import com.example.data.api.story.GetStoryService
import com.example.data.api.story.GetStorySingleService
import com.example.data.api.story.ModifyStoryService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object StoryNetWorkModule {
    @Named("create")
    @Provides
    @Singleton
    fun provideCreateRetrofitInstance(
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

    @Named("get")
    @Provides
    @Singleton
    fun provideGetStoryRetrofitInstance(
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

    @Named("getSingle")
    @Provides
    @Singleton
    fun provideGetSingleStoryRetrofitInstance(
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

    @Named("modifyStory")
    @Provides
    @Singleton
    fun provideModifyStoryRetrofitInstance(
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
    fun provideCreateService(@Named("create") retrofit: Retrofit): CreateStoryService {
        return retrofit.create(CreateStoryService::class.java)
    }

    @Provides
    @Singleton
    fun provideGetStory(@Named("get") retrofit: Retrofit): GetStoryService {
        return retrofit.create(GetStoryService::class.java)
    }

    @Provides
    @Singleton
    fun provideGetSingleStoryService(@Named("getSingle") retrofit: Retrofit): GetStorySingleService {
        return retrofit.create(GetStorySingleService::class.java)
    }

    @Provides
    @Singleton
    fun provideModifyStoryService(@Named("modifyStory") retrofit: Retrofit): ModifyStoryService {
        return retrofit.create(ModifyStoryService::class.java)
    }
}