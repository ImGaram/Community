package com.example.presentation.di.module

import com.example.data.repository.user.remote.login.LoginDataSourceImpl
import com.example.data.repository.user.remote.revision.RevisionDataSourceImpl
import com.example.data.repository.user.repositoryimpl.signin.SignInRepositoryImpl
import com.example.data.repository.user.remote.signin.SignInDataSourceImpl
import com.example.data.repository.user.remote.userinfo.UserInfoDataSourceImpl
import com.example.data.repository.user.repositoryimpl.login.LoginRepositoryImpl
import com.example.data.repository.user.repositoryimpl.revision.RevisionRepositoryImpl
import com.example.data.repository.user.repositoryimpl.userinfo.UserInfoRepositoryImpl
import com.example.domain.repository.user.login.LoginRepository
import com.example.domain.repository.user.revision.RevisionRepository
import com.example.domain.repository.user.signin.SignInRepository
import com.example.domain.repository.user.userinfo.UserInfoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideSignInRepository(signInDataSourceImpl: SignInDataSourceImpl): SignInRepository {
        return SignInRepositoryImpl(signInDataSourceImpl)
    }

    @Provides
    @Singleton
    fun provideLoginRepository(loginDataSourceImpl: LoginDataSourceImpl): LoginRepository {
        return LoginRepositoryImpl(loginDataSourceImpl)
    }

    @Provides
    @Singleton
    fun provideUserInfoRepository(userInfoDataSourceImpl: UserInfoDataSourceImpl): UserInfoRepository {
        return UserInfoRepositoryImpl(userInfoDataSourceImpl)
    }

    @Provides
    @Singleton
    fun provideRevisionRepository(revisionRepositoryImpl: RevisionDataSourceImpl): RevisionRepository {
        return RevisionRepositoryImpl(revisionRepositoryImpl)
    }
}