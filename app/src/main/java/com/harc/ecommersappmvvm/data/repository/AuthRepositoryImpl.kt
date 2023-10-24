package com.harc.ecommersappmvvm.data.repository


import com.harc.ecommersappmvvm.data.dataSource.dataSource.AuthRemoteDataSource
import com.harc.ecommersappmvvm.data.dataSource.dataSourceImpl.AuthLocalDataSource
import com.harc.ecommersappmvvm.domain.model.AuthResponse
import com.harc.ecommersappmvvm.domain.model.User
import com.harc.ecommersappmvvm.domain.repository.AuthRepository
import com.harc.ecommersappmvvm.domain.util.Resource
import com.harc.ecommersappmvvm.domain.util.ResponseToRequest
import kotlinx.coroutines.flow.Flow

class AuthRepositoryImpl(private val authRemoteDataSource: AuthRemoteDataSource,
                         private val authLocalDataSource: AuthLocalDataSource
):AuthRepository {
    override suspend fun login(email: String, password: String): Resource<AuthResponse> =
        ResponseToRequest.send(
            authRemoteDataSource.login(email, password)
        )

    override suspend fun register(user: User): Resource<AuthResponse> = ResponseToRequest.send(
        authRemoteDataSource.register(user)

    )

    override suspend fun saveSession(authResponse: AuthResponse) = authLocalDataSource.saveSession(authResponse)
    override suspend fun updateSession(user: User) = authLocalDataSource.updateSession(user)

    override suspend fun logout() = authLocalDataSource.logout()


    override fun getSessionData(): Flow<AuthResponse> = authLocalDataSource.getSessionData()
}