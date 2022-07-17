package com.example.community.di.module.data

import com.example.data.api.inquiry.*
import com.example.data.datasource.inquiry.remote.*
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

    @Provides
    @Singleton
    fun provideDeleteInquiryDataSource(service: DeleteInquiryService): DeleteInquiryDataSourceImpl {
        return DeleteInquiryDataSourceImpl(service)
    }
}