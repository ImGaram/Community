package com.example.community.di.module

import com.example.data.ApiClient
import com.example.data.api.freeboard.*
import com.example.data.api.user.*
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

    @Named("revision")
    @Provides
    @Singleton
    fun provideRevisionRetrofitInstance(
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

    @Named("del")
    @Provides
    @Singleton
    fun provideDeleteRetrofitInstance(
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

    // free board
    @Named("add")
    @Provides
    @Singleton
    fun provideAddPostRetrofitInstance(
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

    @Named("getPostAll")
    @Provides
    @Singleton
    fun provideGetPostAllRetrofitInstance(
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

    @Named("getPost")
    @Provides
    @Singleton
    fun provideGetPostRetrofitInstance(
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

    @Named("modify")
    @Provides
    @Singleton
    fun provideModifyPostRetrofitInstance(
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

    @Named("delete")
    @Provides
    @Singleton
    fun provideDeletePostRetrofitInstance(
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

    @Named("addComment")
    @Provides
    @Singleton
    fun provideAddCommentRetrofitInstance(
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

    @Named("getComment")
    @Provides
    @Singleton
    fun provideGetCommentRetrofitInstance(
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

    @Named("modifyComment")
    @Provides
    @Singleton
    fun provideModifyCommentRetrofitInstance(
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

    @Named("deleteComment")
    @Provides
    @Singleton
    fun provideDeleteCommentInstance(
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

    @Named("suggest")
    @Provides
    @Singleton
    fun provideSuggestPost(
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

    @Named("getSuggest")
    @Provides
    @Singleton
    fun provideGetSuggestPost(
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

    @Provides
    @Singleton
    fun provideRevisionService(@Named("revision") retrofit: Retrofit): NbRevisionService {
        return retrofit.create(NbRevisionService::class.java)
    }

    @Provides
    @Singleton
    fun provideDeleteUserService(@Named("del") retrofit: Retrofit): NbDeleteUserService {
        return retrofit.create(NbDeleteUserService::class.java)
    }

    // free board
    @Provides
    @Singleton
    fun provideAddPostService(@Named("add") retrofit: Retrofit): FreeAddPostService {
        return retrofit.create(FreeAddPostService::class.java)
    }

    @Provides
    @Singleton
    fun provideGetPostAllService(@Named("getPostAll") retrofit: Retrofit): FreeGetPostAllService {
        return retrofit.create(FreeGetPostAllService::class.java)
    }

    @Provides
    @Singleton
    fun provideGetPostService(@Named("getPost") retrofit: Retrofit): FreeGetPostService {
        return retrofit.create(FreeGetPostService::class.java)
    }

    @Provides
    @Singleton
    fun provideModifyPostService(@Named("modify") retrofit: Retrofit): FreeModifyPostService {
        return retrofit.create(FreeModifyPostService::class.java)
    }

    @Provides
    @Singleton
    fun provideDeletePostService(@Named("delete") retrofit: Retrofit): FreeDeletePostService {
        return retrofit.create(FreeDeletePostService::class.java)
    }

    @Provides
    @Singleton
    fun provideAddCommentService(@Named("addComment") retrofit: Retrofit): AddCommentService {
        return retrofit.create(AddCommentService::class.java)
    }

    @Provides
    @Singleton
    fun provideGetCommentService(@Named("getComment") retrofit: Retrofit): GetCommentService {
        return retrofit.create(GetCommentService::class.java)
    }

    @Provides
    @Singleton
    fun provideModifyCommentService(@Named("modifyComment") retrofit: Retrofit): ModifyCommentService {
        return retrofit.create(ModifyCommentService::class.java)
    }

    @Provides
    @Singleton
    fun provideDeleteCommentService(@Named("deleteComment") retrofit: Retrofit): DeleteCommentService {
        return retrofit.create(DeleteCommentService::class.java)
    }

    @Provides
    @Singleton
    fun provideSuggestPostService(@Named("suggest") retrofit: Retrofit): SuggestService {
        return retrofit.create(SuggestService::class.java)
    }

    @Provides
    @Singleton
    fun provideGetSuggestService(@Named("getSuggest") retrofit: Retrofit): GetSuggestService {
        return retrofit.create(GetSuggestService::class.java)
    }
}