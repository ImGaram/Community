package com.example.community.di.module.data

import com.example.data.api.inquiry.CreateInquiryService
import com.example.data.api.inquiry.GetInquiryListService
import com.example.data.api.inquiry.GetInquiryService
import com.example.data.api.inquiry.ModifyInquiryService
import com.example.data.datasource.inquiry.remote.CreateInquiryDataSourceImpl
import com.example.data.datasource.inquiry.remote.GetInquiryDataSourceImpl
import com.example.data.datasource.inquiry.remote.GetInquiryListDataSourceImpl
import com.example.data.datasource.inquiry.remote.ModifyInquiryDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class InquiryDataSourceModule {
    @Provides
    @Singleton
    fun provideCreateInquiryDataSource(service: CreateInquiryService): CreateInquiryDataSourceImpl {
        return CreateInquiryDataSourceImpl(service)
    }

    @Provides
    @Singleton
    fun provideGetInquiryListDataSource(service: GetInquiryListService): GetInquiryListDataSourceImpl {
        return GetInquiryListDataSourceImpl((service))
    }

    @Provides
    @Singleton
    fun provideGetInquiryDataSource(service: GetInquiryService): GetInquiryDataSourceImpl {
        return GetInquiryDataSourceImpl(service)
    }

    @Provides
    @Singleton
    fun provideModifyInquiryDataSource(service: ModifyInquiryService): ModifyInquiryDataSourceImpl {
        return ModifyInquiryDataSourceImpl(service)
    }
}