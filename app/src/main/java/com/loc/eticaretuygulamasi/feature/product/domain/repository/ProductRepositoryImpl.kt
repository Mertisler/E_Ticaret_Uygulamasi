package com.loc.eticaretuygulamasi.feature.product.domain.repository


import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.loc.eticaretuygulamasi.feature.product.data.mapper.toDomain
import com.loc.eticaretuygulamasi.feature.product.data.remote.ProductApi
import com.loc.eticaretuygulamasi.feature.product.data.remote.paging.ProductPagingSource
import com.loc.eticaretuygulamasi.feature.product.domain.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val api: ProductApi
) : ProductRepository {

    override fun getProducts():
            Flow<PagingData<Product>> {

        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = {
                ProductPagingSource(api)
            }
        ).flow.map { pagingData ->

            pagingData.map {
                it.toDomain()
            }
        }
    }

    override suspend fun getProductById(
        id: Int
    ): Product {

        return api.getProductById(id)
            .toDomain()
    }
}