package com.loc.eticaretuygulamasi.core.network

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @GET("products")
    suspend fun getProducts(): List<ProductDto>

    @GET("products/{id}")
    suspend fun getProductById(
        @Path("id") id: Int
    ): ProductDto

    @POST("auth/login")
    suspend fun login(
        @Body request: LoginRequest
    ): LoginResponse
}