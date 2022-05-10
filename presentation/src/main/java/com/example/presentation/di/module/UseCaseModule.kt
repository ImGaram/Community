package com.example.presentation.di.module

import com.example.domain.repository.user.login.LoginRepository
import com.example.domain.repository.user.signin.SignInRepository
import com.example.domain.usecase.login.LoginUseCase
import com.example.domain.usecase.signin.SignInUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideSignInUseCase(repository: SignInRepository) = SignInUseCase(repository)

    @Provides
    @Singleton
    fun provideLoginUseCase(repository: LoginRepository) = LoginUseCase(repository)
}