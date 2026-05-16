package com.loc.eticaretuygulamasi.feature.product.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.loc.eticaretuygulamasi.feature.product.domain.model.Product

@Composable
fun ProductItem(
    product: Product
) {

    Text(text = product.title)
}