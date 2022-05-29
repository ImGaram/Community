package com.example.presentation.di.module

import com.example.domain.repository.freeboard.AddPostRepository
import com.example.domain.repository.user.delete.DeleteUserRepository
import com.example.domain.repository.user.login.LoginRepository
import com.example.domain.repository.user.revision.RevisionRepository
import com.example.domain.repository.user.signin.SignInRepository
import com.example.domain.repository.user.userinfo.UserInfoRepository
import com.example.domain.usecase.freeboard.AddPostUseCase
import com.example.domain.usecase.user.delete.DeleteUserUseCase
import com.example.domain.usecase.user.login.LoginUseCase
import com.example.domain.usecase.user.revision.RevisionUseCase
import com.example.domain.usecase.user.signin.SignInUseCase
import com.example.domain.usecase.user.userinfo.UserInfoUseCase
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

    @Provides
    @Singleton
    fun provideUserInfoUseCase(repository: UserInfoRepository) = UserInfoUseCase(repository)

    @Provides
    @Singleton
    fun provideRevisionUseCase(repository: RevisionRepository) = RevisionUseCase(repository)

    @Provides
    @Singleton
    fun provideDeleteUserUseCase(repository: DeleteUserRepository) = DeleteUserUseCase(repository)

    // free board
    @Provides
    @Singleton
    fun provideAddPostUseCase(repository: AddPostRepository) = AddPostUseCase(repository)
}