package com.example.community.di.module.network

import com.example.data.ApiClient
import com.example.data.api.story.*
import com.example.data.api.story.comment.CreateStoryCommentService
import com.example.data.api.story.comment.GetCommentListService
import com.example.data.api.story.comment.GetSuggestService
import com.example.data.api.story.comment.SuggestStoryService
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

    @Named("deleteStory")
    @Provides
    @Singleton
    fun provideDeleteStoryRetrofitInstance(
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

    @Named("createComment")
    @Provides
    @Singleton
    fun provideCreateCommentRetrofitInstance(
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

    @Named("getCommentList")
    @Provides
    @Singleton
    fun provideGetCommentListRetrofitInstance(
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

    @Named("suggestStory")
    @Provides
    @Singleton
    fun provideSuggestStoryRetrofitInstance(
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

    @Named("getSuggestStory")
    @Provides
    @Singleton
    fun provideGetSuggestRetrofitInstance(
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

    @Provides
    @Singleton
    fun provideDeleteStoryService(@Named("deleteStory") retrofit: Retrofit): DeleteStoryService {
        return retrofit.create(DeleteStoryService::class.java)
    }

    @Provides
    @Singleton
    fun provideCreateCommentService(@Named("createComment") retrofit: Retrofit): CreateStoryCommentService {
        return retrofit.create(CreateStoryCommentService::class.java)
    }

    @Provides
    @Singleton
    fun provideCreateCommentListService(@Named("getCommentList") retrofit: Retrofit): GetCommentListService {
        return retrofit.create(GetCommentListService::class.java)
    }

    @Provides
    @Singleton
    fun provideSuggestStoryService(@Named("suggestStory") retrofit: Retrofit): SuggestStoryService {
        return retrofit.create(SuggestStoryService::class.java)
    }

    @Provides
    @Singleton
    fun provideGetSuggestService(@Named("getSuggestStory") retrofit: Retrofit): GetSuggestService {
        return retrofit.create(GetSuggestService::class.java)
    }
}