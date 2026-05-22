package com.loc.eticaretuygulamasi.feature.product.presentation

// EKSİK OLAN IMPORT SATIRI BURASIYDI:
import androidx.compose.ui.platform.LocalContext

import android.widget.Toast
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
    val products = viewModel.products.collectAsLazyPagingItems()

    val context = LocalContext.current

    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ) {
        items(products.itemCount) { index ->
            val product = products[index]

            product?.let { currentProduct ->
                ProductItem(
                    product = currentProduct,
                    onAddToCart = {
                        viewModel.addToCart(currentProduct)
                        android.widget.Toast.makeText(
                            context,
                            "${currentProduct.title} sepete eklendi",
                            android.widget.Toast.LENGTH_SHORT
                        ).show()
                    },
                    onAddToFavorites = {
                        viewModel.addToFavorites(currentProduct)


                        android.widget.Toast.makeText(
                            context,
                            "${currentProduct.title} favorilere eklendi",
                            android.widget.Toast.LENGTH_SHORT
                        ).show()
                    }
                )
            }
        }
    }
}