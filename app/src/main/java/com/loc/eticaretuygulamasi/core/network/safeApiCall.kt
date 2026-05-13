package com.loc.eticaretuygulamasi.core.network

import retrofit2.HttpException
import com.loc.eticaretuygulamasi.core.common.Resource
import java.io.IOException

suspend fun <T> safeApiCall(
    apiCall: suspend () -> T
): Resource<T> {

    return try {

        Resource.Success(apiCall())

    } catch (e: IOException) {

        Resource.Error("No internet connection")

    } catch (e: HttpException) {

        Resource.Error("Server error: ${e.code()}")

    } catch (e: Exception) {

        Resource.Error(e.message ?: "Unknown error")
    }
}
