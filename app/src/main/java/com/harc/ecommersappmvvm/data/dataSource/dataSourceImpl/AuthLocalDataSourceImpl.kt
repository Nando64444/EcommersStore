package com.harc.ecommersappmvvm.data.dataSource.dataSourceImpl

import com.harc.ecommersappmvvm.data.dataSource.dataSource.AuthDataStore
import com.harc.ecommersappmvvm.domain.model.AuthResponse
import com.harc.ecommersappmvvm.domain.model.User
import kotlinx.coroutines.flow.Flow

class AuthLocalDataSourceImpl constructor(private val authDataStore: AuthDataStore):
    AuthLocalDataSource {
    override suspend fun saveSession(authResponse: AuthResponse) = authDataStore.saveUser(authResponse)
    override suspend fun updateSession(user: User) = authDataStore.update(user)
    override suspend fun logout() = authDataStore.delete()
    override fun getSessionData(): Flow<AuthResponse> = authDataStore.getData()


}