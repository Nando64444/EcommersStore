package com.harc.ecommersappmvvm.domain.model

import android.util.Log
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

data class Category(
    @SerializedName("id") val id: String? = null,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("image") val image: String? = null,
): Serializable{

    fun toJson(): String = Gson().toJson(Category(
        id,
        name,
        description,
        if (!image.isNullOrBlank()) URLEncoder.encode(image, StandardCharsets.UTF_8.toString()) else "",

        ))

    companion object {
        fun fromJson(data: String): Rol = Gson().fromJson(data, Rol::class.java)
    }
}
