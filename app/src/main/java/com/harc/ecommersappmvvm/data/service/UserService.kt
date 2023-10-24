package com.harc.ecommersappmvvm.data.service

import com.harc.ecommersappmvvm.domain.model.User
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path

interface UserService {

    @PUT("users/{id}")
    suspend fun update(
        @Path("id") id: String,
        @Body() user: User,
    ): Response<User>

    @Multipart
    @PUT("users/upload/{id}")
    suspend fun updateWithImage(
        @Part file: MultipartBody.Part,
        @Path("id") id: String,
        @Part("name") name: RequestBody,
        @Part("lastName") lastName: RequestBody,
        @Part("phone") phone: RequestBody,
    ): Response<User>

}