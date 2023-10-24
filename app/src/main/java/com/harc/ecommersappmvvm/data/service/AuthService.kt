package com.harc.ecommersappmvvm.data.service

import com.harc.ecommersappmvvm.domain.model.AuthResponse
import com.harc.ecommersappmvvm.domain.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthService {

    //https://192.168.0.41:3000/auth/login
    @FormUrlEncoded
    @POST("auth/login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String,
    ): Response<AuthResponse>

    @POST("auth/register")
    suspend fun register(
        @Body() user: User,
    ): Response<AuthResponse>

}