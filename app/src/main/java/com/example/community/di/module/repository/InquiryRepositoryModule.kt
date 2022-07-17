package com.example.community.di.module.repository

import com.example.data.datasource.inquiry.remote.*
import com.example.data.datasource.inquiry.repositoryimpl.*
import com.example.domain.repository.inquiry.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class InquiryRepositoryModule {
    @Provides
    @Singleton
    fun provideCreateInquiryRepository(dataSourceImpl: CreateInquiryDataSourceImpl): CreateInquiryRepository {
        return CreateInquiryRepositoryImpl(dataSourceImpl)
    }

    @Provides
    @Singleton
    fun provideGetInquiryListRepository(dataSourceImpl: GetInquiryListDataSourceImpl): GetInquiryListRepository {
        return GetInquiryListRepositoryImpl(dataSourceImpl)
    }

    @Provides
    @Singleton
    fun provideGetInquiryRepository(dataSourceImpl: GetInquiryDataSourceImpl): GetInquiryRepository {
        return GetInquiryRepositoryImpl(dataSourceImpl)
    }

    @Provides
    @Singleton
    fun provideModifyInquiryRepository(dataSourceImpl: ModifyInquiryDataSourceImpl): ModifyInquiryRepository {
        return ModifyInquiryRepositoryImpl(dataSourceImpl)
    }

    @Provides
    @Singleton
    fun provideDeleteInquiryRepository(dataSourceImpl: DeleteInquiryDataSourceImpl): DeleteInquiryRepository {
        return DeleteInquiryRepositoryImpl(dataSourceImpl)
    }
}