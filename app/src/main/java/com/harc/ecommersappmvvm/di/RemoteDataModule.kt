package com.harc.ecommersappmvvm.di

import com.harc.ecommersappmvvm.data.dataSource.dataSource.AuthRemoteDataSource
import com.harc.ecommersappmvvm.data.dataSource.dataSource.CategoriesRemoteDataSource
import com.harc.ecommersappmvvm.data.dataSource.dataSource.UserRemoteDataSource
import com.harc.ecommersappmvvm.data.dataSource.dataSourceImpl.AuthRemoteDataSourceImpl
import com.harc.ecommersappmvvm.data.dataSource.dataSourceImpl.CategoriesRemoteDataSourceImpl
import com.harc.ecommersappmvvm.data.dataSource.dataSourceImpl.UserRemoteDataSourceImpl
import com.harc.ecommersappmvvm.data.service.AuthService
import com.harc.ecommersappmvvm.data.service.CategoriesService
import com.harc.ecommersappmvvm.data.service.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

    @Module
    @InstallIn(SingletonComponent::class)
    object RemoteDataModule{
        @Provides
        fun provideAuthRemoteDataSource(authService: AuthService): AuthRemoteDataSource = AuthRemoteDataSourceImpl(authService)

        @Provides
        fun UserRemoteDataSource(userService: UserService): UserRemoteDataSource = UserRemoteDataSourceImpl(userService)
        @Provides
        fun provideCategoriesRemoteDataSource(categoriesService: CategoriesService):
                CategoriesRemoteDataSource = CategoriesRemoteDataSourceImpl(categoriesService)
    }


