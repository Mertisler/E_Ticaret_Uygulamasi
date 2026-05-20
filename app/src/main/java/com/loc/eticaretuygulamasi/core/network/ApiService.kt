package com.loc.eticaretuygulamasi.core.network

import com.loc.eticaretuygulamasi.feature.product.data.remote.dto.ProductDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    // Sadece ürünleri listelemek için
    @GET("products")
    suspend fun getProducts(): List<ProductDto>

    // Sadece tek bir ürünün detayını getirmek için
    @GET("products/{id}")
    suspend fun getProductById(
        @Path("id") id: Int
    ): ProductDto

}