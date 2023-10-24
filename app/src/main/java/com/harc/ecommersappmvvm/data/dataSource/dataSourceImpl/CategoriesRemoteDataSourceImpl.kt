package com.harc.ecommersappmvvm.data.dataSource.dataSourceImpl

import android.util.Log
import com.harc.ecommersappmvvm.data.dataSource.dataSource.CategoriesRemoteDataSource
import com.harc.ecommersappmvvm.data.service.CategoriesService
import com.harc.ecommersappmvvm.domain.model.Category
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Response
import java.io.File

class CategoriesRemoteDataSourceImpl(private val categoriesService: CategoriesService):
 CategoriesRemoteDataSource {
 override suspend fun create(category: Category, file: File): Response<Category> {
  val connection = withContext(Dispatchers.IO){
   file.toURI().toURL().openConnection()
  }
  val mimeType = connection.contentType
  val contentType = "text/plain"
  val requestFile = file.asRequestBody(mimeType.toMediaTypeOrNull())
  val fileFormData = MultipartBody.Part.createFormData("file", file.name, requestFile)
  val nameData = category.name.toRequestBody(contentType.toMediaTypeOrNull())
  val descriptionData = category.description.toRequestBody(contentType.toMediaTypeOrNull())


  Log.d("Categorias", "Enviando datos para crear categoría")
  Log.d("Categorias", "File: ${file.name}")
  Log.d("Categorias", "Name: ${category.name}")
  Log.d("Categorias", "Description: ${category.description}")
  return categoriesService.create(fileFormData, nameData, descriptionData)

 }

 override suspend fun getCategories(): Response<List<Category>> = categoriesService.getCategories()

 override suspend fun update(id: String, category: Category): Response<Category> {
  TODO("Not yet implemented")
 }

 override suspend fun updateWithImage(
  id: String,
  category: Category,
  file: File
 ): Response<Category> {
  TODO("Not yet implemented")
 }

 override suspend fun delete(id: String): Response<Unit> {
  TODO("Not yet implemented")
 }


}



