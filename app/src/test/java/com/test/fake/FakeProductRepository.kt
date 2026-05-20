package com.test.fake

import androidx.paging.PagingData
import com.loc.eticaretuygulamasi.feature.product.domain.model.Product
import com.loc.eticaretuygulamasi.feature.product.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeProductRepository : ProductRepository {

    private val products = listOf(

        Product(
            id = 1,
            title = "iPhone",
            price = 999.0,
            description = "Apple phone",
            category = "electronics",
            image = "",
            rating = 4.5
        ),

        Product(
            id = 2,
            title = "Samsung",
            price = 799.0,
            description = "Samsung phone",
            category = "electronics",
            image = "",
            rating = 4.3
        )
    )

    override fun getProducts():
            Flow<PagingData<Product>> {

        return flowOf(
            PagingData.from(products)
        )
    }

    override suspend fun getProductById(
        id: Int
    ): Product {

        return products.first {
            it.id == id
        }
    }
}