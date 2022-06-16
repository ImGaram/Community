package com.example.community.di.module

import com.example.data.api.freeboard.FreeAddPostService
import com.example.data.api.freeboard.FreeGetPostAllService
import com.example.data.api.freeboard.FreeGetPostService
import com.example.data.api.freeboard.FreeModifyPostService
import com.example.data.api.user.*
import com.example.data.datasource.freeboard.remote.addpost.AddPostDataSourceImpl
import com.example.data.datasource.freeboard.remote.getpost.GetPostDataSource
import com.example.data.datasource.freeboard.remote.getpost.GetPostDataSourceImpl
import com.example.data.datasource.freeboard.remote.getpostall.GetPostAllDataSourceImpl
import com.example.data.datasource.freeboard.remote.modify.ModifyFreeBoardDatasourceImpl
import com.example.data.datasource.user.remote.delete.DeleteUserDataSourceImpl
import com.example.data.datasource.user.remote.login.LoginDataSourceImpl
import com.example.data.datasource.user.remote.revision.RevisionDataSourceImpl
import com.example.data.datasource.user.remote.signin.SignInDataSourceImpl
import com.example.data.datasource.user.remote.userinfo.UserInfoDataSourceImpl
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

    @Provides
    @Singleton
    fun provideDeleteDataSource(deleteUserService: NbDeleteUserService): DeleteUserDataSourceImpl {
        return DeleteUserDataSourceImpl(deleteUserService)
    }

    // free board
    @Provides
    @Singleton
    fun provideAddPostDataSource(freeAddPostService: FreeAddPostService): AddPostDataSourceImpl {
        return AddPostDataSourceImpl(freeAddPostService)
    }

    @Provides
    @Singleton
    fun provideGetAllPostDataSource(freeGetPostAllService: FreeGetPostAllService): GetPostAllDataSourceImpl {
        return GetPostAllDataSourceImpl(freeGetPostAllService)
    }

    @Provides
    @Singleton
    fun provideGetPostDataSource(freeGetPostService: FreeGetPostService): GetPostDataSourceImpl {
        return GetPostDataSourceImpl((freeGetPostService))
    }

    @Provides
    @Singleton
    fun provideModifyPostDataSource(modifyService: FreeModifyPostService): ModifyFreeBoardDatasourceImpl {
        return ModifyFreeBoardDatasourceImpl(modifyService)
    }
}