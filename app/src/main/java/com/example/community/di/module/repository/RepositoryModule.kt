package com.example.community.di.module.repository

import com.example.data.datasource.freeboard.remote.addpost.AddPostDataSourceImpl
import com.example.data.datasource.freeboard.remote.comment.AddCommentDataSourceImpl
import com.example.data.datasource.freeboard.remote.comment.DeleteCommentDataSourceImpl
import com.example.data.datasource.freeboard.remote.comment.GetCommentDataSourceImpl
import com.example.data.datasource.freeboard.remote.comment.ModifyCommentDataSourceImpl
import com.example.data.datasource.freeboard.remote.delete.DeletePostDataSourceImpl
import com.example.data.datasource.freeboard.remote.getpost.GetPostDataSourceImpl
import com.example.data.datasource.freeboard.remote.getpostall.GetPostAllDataSourceImpl
import com.example.data.datasource.freeboard.remote.modify.ModifyFreeBoardDatasourceImpl
import com.example.data.datasource.freeboard.remote.suggest.GetSuggestDataSourceImpl
import com.example.data.datasource.freeboard.remote.suggest.SuggestDataSourceImpl
import com.example.data.datasource.freeboard.repositoryimpl.addpost.AddPostRepositoryImpl
import com.example.data.datasource.freeboard.repositoryimpl.comment.AddCommentRepositoryImpl
import com.example.data.datasource.freeboard.repositoryimpl.comment.DeleteCommentRepositoryImpl
import com.example.data.datasource.freeboard.repositoryimpl.comment.GetCommentRepositoryImpl
import com.example.data.datasource.freeboard.repositoryimpl.comment.ModifyCommentRepositoryImpl
import com.example.data.datasource.freeboard.repositoryimpl.delete.DeletePostRepositoryImpl
import com.example.data.datasource.freeboard.repositoryimpl.getpost.GetPostRepositoryImpl
import com.example.data.datasource.freeboard.repositoryimpl.getpostall.GetPostAllRepositoryImpl
import com.example.data.datasource.freeboard.repositoryimpl.modify.ModifyPostRepositoryImpl
import com.example.data.datasource.freeboard.repositoryimpl.suggest.GetSuggestPostRepositoryImpl
import com.example.data.datasource.freeboard.repositoryimpl.suggest.SuggestPostRepositoryImpl
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
import com.example.domain.repository.freeboard.addpost.AddPostRepository
import com.example.domain.repository.freeboard.comment.AddCommentRepository
import com.example.domain.repository.freeboard.comment.DeleteCommentRepository
import com.example.domain.repository.freeboard.comment.GetCommentRepository
import com.example.domain.repository.freeboard.comment.ModifyCommentRepository
import com.example.domain.repository.freeboard.delete.DeletePostRepository
import com.example.domain.repository.freeboard.getpost.GetPostRepository
import com.example.domain.repository.freeboard.getpostall.GetPostAllRepository
import com.example.domain.repository.freeboard.modify.ModifyPostRepository
import com.example.domain.repository.freeboard.suggest.GetSuggestRepository
import com.example.domain.repository.freeboard.suggest.SuggestPostRepository
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

    @Provides
    @Singleton
    fun provideGetPostAllRepository(getPostDataSourceImpl: GetPostAllDataSourceImpl): GetPostAllRepository {
        return GetPostAllRepositoryImpl(getPostDataSourceImpl)
    }

    @Provides
    @Singleton
    fun provideGetPostRepository(getPostDataSourceImpl: GetPostDataSourceImpl): GetPostRepository {
        return GetPostRepositoryImpl(getPostDataSourceImpl)
    }

    @Provides
    @Singleton
    fun provideModifyPostRepository(modifyPostRepository: ModifyFreeBoardDatasourceImpl): ModifyPostRepository {
        return ModifyPostRepositoryImpl(modifyPostRepository)
    }

    @Provides
    @Singleton
    fun provideDeletePostRepository(deletePostRepository: DeletePostDataSourceImpl): DeletePostRepository {
        return DeletePostRepositoryImpl(deletePostRepository)
    }

    @Provides
    @Singleton
    fun provideAddCommentRepository(addCommentRepository: AddCommentDataSourceImpl): AddCommentRepository {
        return AddCommentRepositoryImpl(addCommentRepository)
    }

    @Provides
    @Singleton
    fun provideGetCommentRepository(getCommentDataSourceImpl: GetCommentDataSourceImpl): GetCommentRepository {
        return GetCommentRepositoryImpl(getCommentDataSourceImpl)
    }

    @Provides
    @Singleton
    fun provideModifyCommentRepository(modifyCommentDataSourceImpl: ModifyCommentDataSourceImpl): ModifyCommentRepository {
        return ModifyCommentRepositoryImpl(modifyCommentDataSourceImpl)
    }

    @Provides
    @Singleton
    fun provideDeleteCommentRepository(deleteCommentDataSourceImpl: DeleteCommentDataSourceImpl): DeleteCommentRepository {
        return DeleteCommentRepositoryImpl(deleteCommentDataSourceImpl)
    }

    @Provides
    @Singleton
    fun provideSuggestPostRepository(suggestPostDataSourceImpl: SuggestDataSourceImpl): SuggestPostRepository {
        return SuggestPostRepositoryImpl(suggestPostDataSourceImpl)
    }

    @Provides
    @Singleton
    fun provideGetSuggestPostRepository(getSuggestDataSourceImpl: GetSuggestDataSourceImpl): GetSuggestRepository {
        return GetSuggestPostRepositoryImpl(getSuggestDataSourceImpl)
    }
}