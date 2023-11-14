package com.harc.ecommersappmvvm.data.dataSource.dataSourceImpl

import com.harc.ecommersappmvvm.data.dataSource.dataSource.AuthRemoteDataSource
import com.harc.ecommersappmvvm.data.service.AuthService
import com.harc.ecommersappmvvm.domain.model.AuthResponse
import com.harc.ecommersappmvvm.domain.model.User
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response
import java.net.ConnectException

class AuthRemoteDataSourceImpl(private val authService: AuthService) : AuthRemoteDataSource {

    override suspend fun login(email: String, password: String): Response<AuthResponse> {
        return try {
            authService.login(email, password)
        } catch (e: ConnectException) {
            // Excepciones
            // Excepciones
            Response.error(503, "El servidor no está disponible".toResponseBody(null))
        } catch (e: Exception) {
            // Excepciones
            throw e
        }
    }


    override suspend fun register(user: User): Response<AuthResponse> {
        return try {
            authService.register(user)
        } catch (e: Exception) {
            Response.error(503, "El servidor no está disponible".toResponseBody(null))
        } catch (e: Exception) {
            // Excepciones
            throw e
        }
    }
}




