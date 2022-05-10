package com.example.presentation.di.module

import com.example.data.repository.user.remote.login.LoginDataSourceImpl
import com.example.data.repository.user.repositoryimpl.signin.SignInRepositoryImpl
import com.example.data.repository.user.remote.signin.SignInDataSourceImpl
import com.example.data.repository.user.repositoryimpl.login.LoginRepositoryImpl
import com.example.domain.repository.user.login.LoginRepository
import com.example.domain.repository.user.signin.SignInRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlin.math.log

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
}