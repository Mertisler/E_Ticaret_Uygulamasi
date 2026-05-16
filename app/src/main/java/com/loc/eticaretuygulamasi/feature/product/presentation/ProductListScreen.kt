package com.loc.eticaretuygulamasi.feature.product.presentation

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems


@Composable
fun ProductListScreen(
    viewModel: ProductViewModel = hiltViewModel()
) {

    val products =
        viewModel.products.collectAsLazyPagingItems()

    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ) {

        items(products.itemCount) { index ->

            val product = products[index]

            product?.let {

                ProductItem(product = it)
            }
        }
    }
}