package com.harc.ecommersappmvvm.di

import com.harc.ecommersappmvvm.data.dataSource.dataSource.AuthDataStore
import com.harc.ecommersappmvvm.data.dataSource.dataSourceImpl.AuthLocalDataSource
import com.harc.ecommersappmvvm.data.dataSource.dataSourceImpl.AuthLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

    @Module
    @InstallIn(SingletonComponent::class)
    object LocalDataModule{
        @Provides
        fun provideAuthLocalDataSource(authDataStore: AuthDataStore): AuthLocalDataSource = AuthLocalDataSourceImpl(authDataStore)
    }
