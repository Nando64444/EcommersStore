package com.harc.ecommersappmvvm.domain.model

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

data class User(
   @SerializedName("id") val id: String? = null,
   @SerializedName("name") var name: String,
   @SerializedName("lastName") var lastName: String,
   @SerializedName("email") var email: String? =null,
   @SerializedName("phone") var phone: String,
   @SerializedName("password") val password: String? =null,
   @SerializedName("image") var image: String? = null,
   @SerializedName("notification_token") val notificationToken: String? = null,
   @SerializedName("roles") val roles: List<Rol>? = null,
): Serializable{

   fun toJson(): String = Gson().toJson(User(
      id,
      name,
      lastName,
      email,
      phone,
      password,
      if (!image.isNullOrBlank()) URLEncoder.encode(image, StandardCharsets.UTF_8.toString()) else "",
      notificationToken,
      roles?.map { rol ->  Rol.fromJson(rol.toJson()) }
   ))

   companion object {
      fun fromJson(data:String): User = Gson().fromJson(data, User::class.java)
   }
}
