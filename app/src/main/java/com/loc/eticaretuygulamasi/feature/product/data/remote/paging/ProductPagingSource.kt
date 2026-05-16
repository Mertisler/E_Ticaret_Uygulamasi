package com.loc.eticaretuygulamasi.feature.product.data.remote.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.loc.eticaretuygulamasi.feature.product.data.remote.ProductApi
import com.loc.eticaretuygulamasi.feature.product.data.remote.dto.ProductDto

class ProductPagingSource(
    private val api: ProductApi
) : PagingSource<Int, ProductDto>() {

    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, ProductDto> {

        return try {

            val response = api.getProducts()

            LoadResult.Page(
                data = response,
                prevKey = null,
                nextKey = null
            )

        } catch (e: Exception) {

            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(
        state: PagingState<Int, ProductDto>
    ): Int? {
        return state.anchorPosition
    }
}