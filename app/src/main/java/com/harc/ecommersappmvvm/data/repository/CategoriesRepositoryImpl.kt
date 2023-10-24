package com.harc.ecommersappmvvm.data.repository

import com.harc.ecommersappmvvm.data.dataSource.dataSource.CategoriesRemoteDataSource
import com.harc.ecommersappmvvm.domain.model.Category
import com.harc.ecommersappmvvm.domain.repository.CategoriesRepository
import com.harc.ecommersappmvvm.domain.util.Resource
import com.harc.ecommersappmvvm.domain.util.ResponseToRequest
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import java.io.File

class CategoriesRepositoryImpl(private val categoriesRemoteDataSource: CategoriesRemoteDataSource): CategoriesRepository {

        override suspend fun create(category: Category, file: File): Resource<Category> = ResponseToRequest.send(
            (categoriesRemoteDataSource.create(category, file))
        )

        override suspend fun getCategories(): Flow<Resource<List<Category>>> = callbackFlow {
            trySend(ResponseToRequest.send(categoriesRemoteDataSource.getCategories()))
            awaitClose{
                cancel()
            }
        }

        override suspend fun update(id: String, category: Category): Resource<Category> {
            TODO("Not yet implemented")
        }

        override suspend fun updateWithImage(
            id: String,
            category: Category,
            file: File
        ): Resource<Category> {
            TODO("Not yet implemented")
        }

        override suspend fun delete(id: String): Resource<Unit> {
            TODO("Not yet implemented")
        }
    }
