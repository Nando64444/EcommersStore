package com.harc.ecommersappmvvm.di

import com.harc.ecommersappmvvm.data.dataSource.dataSourceImpl.AuthLocalDataSource
import com.harc.ecommersappmvvm.data.repository.AuthRepositoryImpl
import com.harc.ecommersappmvvm.data.repository.UserRepositoryImpl
import com.harc.ecommersappmvvm.data.dataSource.dataSource.AuthRemoteDataSource
import com.harc.ecommersappmvvm.data.dataSource.dataSource.CategoriesRemoteDataSource
import com.harc.ecommersappmvvm.data.dataSource.dataSource.UserRemoteDataSource
import com.harc.ecommersappmvvm.data.repository.CategoriesRepositoryImpl
import com.harc.ecommersappmvvm.domain.repository.AuthRepository
import com.harc.ecommersappmvvm.domain.repository.CategoriesRepository
import com.harc.ecommersappmvvm.domain.repository.UsersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

    @Module
    @InstallIn(SingletonComponent::class)
    object RepositoryModule{
        @Provides
        fun provideAuthRepository(authRemoteDataSource: AuthRemoteDataSource,
                                  authLocalDataSource: AuthLocalDataSource
        ):AuthRepository = AuthRepositoryImpl(authRemoteDataSource, authLocalDataSource)

        @Provides
        fun provideUserRepository(userRemoteDataSource: UserRemoteDataSource,
        ): UsersRepository = UserRepositoryImpl(userRemoteDataSource)

        @Provides
        fun provideCategoriesRepository(categoriesRemoteDataSource: CategoriesRemoteDataSource,
        ): CategoriesRepository = CategoriesRepositoryImpl(categoriesRemoteDataSource)

    }

