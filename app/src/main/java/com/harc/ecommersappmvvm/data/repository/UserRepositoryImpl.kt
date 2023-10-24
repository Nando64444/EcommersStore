package com.harc.ecommersappmvvm.data.repository


import com.harc.ecommersappmvvm.data.dataSource.dataSource.UserRemoteDataSource
import com.harc.ecommersappmvvm.domain.model.User
import com.harc.ecommersappmvvm.domain.repository.UsersRepository
import com.harc.ecommersappmvvm.domain.util.Resource
import com.harc.ecommersappmvvm.domain.util.ResponseToRequest
import java.io.File

class UserRepositoryImpl(private val userRemoteDataSource: UserRemoteDataSource):UsersRepository {

    override suspend fun update(id: String, user: User): Resource<User> = ResponseToRequest.send(
        userRemoteDataSource.update(id, user))

    override suspend fun updateWithIMage(id: String, user: User, file: File) = ResponseToRequest.send(
        userRemoteDataSource.updateWithImage(id, user, file))


}