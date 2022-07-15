package com.example.community.di.module.repository

import com.example.data.datasource.inquiry.remote.CreateInquiryDataSourceImpl
import com.example.data.datasource.inquiry.remote.GetInquiryDataSourceImpl
import com.example.data.datasource.inquiry.remote.GetInquiryListDataSourceImpl
import com.example.data.datasource.inquiry.repositoryimpl.CreateInquiryRepositoryImpl
import com.example.data.datasource.inquiry.repositoryimpl.GetInquiryListRepositoryImpl
import com.example.data.datasource.inquiry.repositoryimpl.GetInquiryRepositoryImpl
import com.example.domain.repository.inquiry.CreateInquiryRepository
import com.example.domain.repository.inquiry.GetInquiryListRepository
import com.example.domain.repository.inquiry.GetInquiryRepository
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
}