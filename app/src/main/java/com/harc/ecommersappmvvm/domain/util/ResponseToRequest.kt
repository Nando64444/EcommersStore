package com.harc.ecommersappmvvm.domain.util

import android.util.Log
import com.harc.ecommersappmvvm.domain.model.ErrorResponse
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

object ResponseToRequest {

    fun <T> send(result: Response<T>): Resource<T> {
        return try {
            if (result.isSuccessful) {//201
                Resource.Success(result.body()!!)
            } else {
                val errorResponse: ErrorResponse? = ConvertErrorBody.convert(result.errorBody())
                Log.d("errorResponse", "Reponse: ${errorResponse}")
                Resource.Failure(errorResponse?.message ?: "Error Desconocido")
            }
        } catch (e: HttpException) {
            e.printStackTrace()
            Resource.Failure(e.message ?: "Error Desconocido en la petición Http")
        } catch (e: IOException) {
            e.printStackTrace()
            Resource.Failure("Verifica tu conexión a internet")
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Failure(e.message ?: "Error Desconocido")
        }
    }
}
