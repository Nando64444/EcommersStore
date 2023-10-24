package com.harc.ecommersappmvvm.data.dataSource.dataSourceImpl

import com.harc.ecommersappmvvm.data.dataSource.dataSource.AuthRemoteDataSource
import com.harc.ecommersappmvvm.data.service.AuthService
import com.harc.ecommersappmvvm.domain.model.AuthResponse
import com.harc.ecommersappmvvm.domain.model.User
import retrofit2.Response

class AuthRemoteDataSourceImpl(private val authService: AuthService): AuthRemoteDataSource {

    override suspend fun login(email:String, password:String) = authService.login(email, password)
    override suspend fun register(user: User): Response<AuthResponse> = authService.register(user)

}



