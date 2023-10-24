package com.harc.ecommersappmvvm.data.dataSource.dataSourceImpl

import com.harc.ecommersappmvvm.data.dataSource.dataSource.UserRemoteDataSource
import com.harc.ecommersappmvvm.data.service.UserService
import com.harc.ecommersappmvvm.domain.model.User
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Response
import java.io.File

class UserRemoteDataSourceImpl(private val userService: UserService): UserRemoteDataSource {

 override suspend fun update(id:String, user: User): Response<User> = userService.update(id, user)
 override suspend fun updateWithImage(id: String, user: User, file: File): Response<User> {

  val connection = file.toURI().toURL().openConnection()
  val mimeType = connection.contentType
  val contentType = "text/plain"
  val requestFile = file.asRequestBody(mimeType.toMediaTypeOrNull())
  val fileForData = MultipartBody.Part.createFormData("file", file.name, requestFile)
  val nameData = user.name.toRequestBody(contentType.toMediaTypeOrNull())
  val lastNameData = user.lastName.toRequestBody(contentType.toMediaTypeOrNull())
  val phoneData = user.phone.toRequestBody(contentType.toMediaTypeOrNull())

  return userService.updateWithImage(fileForData, id, nameData, lastNameData, phoneData)
 }

}



