package com.example.presentation.di.module

import com.example.data.api.NbService
import com.example.data.repository.remote.SignInDataSourceImpl
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
    fun provideLoginDataSource(service: NbService): SignInDataSourceImpl {
        return SignInDataSourceImpl(service)
    }
}