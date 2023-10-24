package com.harc.ecommersappmvvm.di

import com.harc.ecommersappmvvm.core.Config
import com.harc.ecommersappmvvm.data.dataSource.dataSource.AuthDataStore
import com.harc.ecommersappmvvm.data.service.AuthService
import com.harc.ecommersappmvvm.data.service.CategoriesService
import com.harc.ecommersappmvvm.data.service.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(dataStore: AuthDataStore) = OkHttpClient.Builder().addInterceptor{
        val token = runBlocking {
            dataStore.getData().first().token
        }

        val newRequest = it.request().newBuilder().addHeader("Authorization", token ?: "").build()
        it.proceed(newRequest)
    }.build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient):Retrofit{
        return Retrofit
            .Builder()
            .baseUrl(Config.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
    @Provides
    @Singleton
    fun provideAuthService(retrofit: Retrofit):AuthService{
        return retrofit.create(AuthService::class.java)
    }
    @Provides
    @Singleton
    fun provideUserService(retrofit: Retrofit): UserService {
        return retrofit.create(UserService::class.java)
    }
    @Provides
    @Singleton
    fun provideCategoriesService(retrofit: Retrofit): CategoriesService {
        return retrofit.create(CategoriesService::class.java)
    }




}