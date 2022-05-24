package com.example.presentation.di.module

import com.example.data.api.NbJoinService
import com.example.data.api.NbLoginService
import com.example.data.api.NbRevisionService
import com.example.data.api.NbUserInfoService
import com.example.data.repository.user.remote.login.LoginDataSourceImpl
import com.example.data.repository.user.remote.revision.RevisionDataSourceImpl
import com.example.data.repository.user.remote.signin.SignInDataSourceImpl
import com.example.data.repository.user.remote.userinfo.UserInfoDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideSignInDataSource(joinService: NbJoinService): SignInDataSourceImpl {
        return SignInDataSourceImpl(joinService)
    }

    @Provides
    @Singleton
    fun provideLoginDataSource(loginService: NbLoginService): LoginDataSourceImpl {
        return LoginDataSourceImpl(loginService)
    }

    @Provides
    @Singleton
    fun provideUserInfoDataSource(userInfoService: NbUserInfoService): UserInfoDataSourceImpl {
        return UserInfoDataSourceImpl(userInfoService)
    }

    @Provides
    @Singleton
    fun provideRevisionDataSource(revisionService: NbRevisionService): RevisionDataSourceImpl {
        return RevisionDataSourceImpl(revisionService)
    }
}