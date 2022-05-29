package com.example.presentation.di.module

import com.example.data.datasource.freeboard.remote.AddPostDataSourceImpl
import com.example.data.datasource.freeboard.repositoryimpl.AddPostRepositoryImpl
import com.example.data.datasource.user.remote.delete.DeleteUserDataSourceImpl
import com.example.data.datasource.user.remote.login.LoginDataSourceImpl
import com.example.data.datasource.user.remote.revision.RevisionDataSourceImpl
import com.example.data.datasource.user.repositoryimpl.signin.SignInRepositoryImpl
import com.example.data.datasource.user.remote.signin.SignInDataSourceImpl
import com.example.data.datasource.user.remote.userinfo.UserInfoDataSourceImpl
import com.example.data.datasource.user.repositoryimpl.delete.DeleteRepositoryImpl
import com.example.data.datasource.user.repositoryimpl.login.LoginRepositoryImpl
import com.example.data.datasource.user.repositoryimpl.revision.RevisionRepositoryImpl
import com.example.data.datasource.user.repositoryimpl.userinfo.UserInfoRepositoryImpl
import com.example.domain.repository.freeboard.AddPostRepository
import com.example.domain.repository.user.delete.DeleteUserRepository
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

    @Provides
    @Singleton
    fun provideDeleteRepository(deleteRepositoryImpl: DeleteUserDataSourceImpl): DeleteUserRepository {
        return DeleteRepositoryImpl(deleteRepositoryImpl)
    }

    // free board
    @Provides
    @Singleton
    fun provideAddPostRepository(addPostDataSourceImpl: AddPostDataSourceImpl): AddPostRepository {
        return AddPostRepositoryImpl(addPostDataSourceImpl)
    }
}