package com.loc.eticaretuygulamasi.feature.product.domain.repository

import androidx.paging.PagingData
import com.loc.eticaretuygulamasi.feature.product.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    fun getProducts(): Flow<PagingData< Product>>

    suspend fun getProductById(id: Int): Product
}