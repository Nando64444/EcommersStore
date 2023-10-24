package com.harc.ecommersappmvvm.data.dataSource.dataSource

import com.harc.ecommersappmvvm.domain.model.AuthResponse
import com.harc.ecommersappmvvm.domain.model.User
import retrofit2.Response

interface AuthRemoteDataSource {

    suspend fun login(email:String, password:String): Response<AuthResponse>
    suspend fun register(user: User): Response<AuthResponse>

}