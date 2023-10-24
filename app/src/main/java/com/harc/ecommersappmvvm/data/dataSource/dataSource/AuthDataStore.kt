package com.harc.ecommersappmvvm.data.dataSource.dataSource

import android.annotation.SuppressLint
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.harc.ecommersappmvvm.core.Config.AUTH_KEY
import com.harc.ecommersappmvvm.domain.model.AuthResponse
import com.harc.ecommersappmvvm.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

class AuthDataStore constructor(private val dataStore: DataStore<Preferences>) {

    suspend fun saveUser(authResponse: AuthResponse) {
        val dataStoreKey = stringPreferencesKey(AUTH_KEY)
        dataStore.edit { pref ->
            pref[dataStoreKey] = authResponse.toJson()

        }
    }
        @SuppressLint("SuspiciousIndentation")
        suspend fun update(user: User) {
        val dataStoreKey = stringPreferencesKey(AUTH_KEY)
        val authResponse = runBlocking {
            getData().first()
        }
            Log.d("AuthDataStore", "User: ${user.toJson()}")
        authResponse.user?.name = user.name
        authResponse.user?.lastName = user.lastName
        authResponse.user?.phone = user.phone

            if (!user.image.isNullOrBlank()) authResponse.user?.image = user.image
        dataStore.edit { pref ->
            pref[dataStoreKey] = authResponse.toJson()

        }
    }
        suspend fun delete() {
            val dataStoreKey = stringPreferencesKey(AUTH_KEY)
            dataStore.edit { pref ->
                pref.remove(dataStoreKey)

            }
        }

        fun getData(): Flow<AuthResponse> {
            val dataStoreKey = stringPreferencesKey(AUTH_KEY)
            return dataStore.data.map { pref ->
                if (pref[dataStoreKey] != null) {
                    AuthResponse.fromJson(pref[dataStoreKey]!!)
                } else {
                    AuthResponse()
                }
            }
        }
}
