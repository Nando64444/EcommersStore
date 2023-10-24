package com.harc.ecommersappmvvm.domain.repository

import com.harc.ecommersappmvvm.domain.model.User
import com.harc.ecommersappmvvm.domain.util.Resource
import java.io.File

interface UsersRepository {

    suspend fun update(id: String, user: User): Resource<User>
    suspend fun updateWithIMage(id: String, user: User, file: File): Resource<User>
}