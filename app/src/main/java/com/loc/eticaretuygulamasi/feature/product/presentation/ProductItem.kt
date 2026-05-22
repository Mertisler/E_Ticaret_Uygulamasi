package com.loc.eticaretuygulamasi.feature.product.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.loc.eticaretuygulamasi.feature.product.domain.model.Product

@Composable
fun ProductItem(
    product: Product,
    onAddToCart: () -> Unit,
    onAddToFavorites: () -> Unit
) {
    Card(modifier = Modifier.padding(8.dp)) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            AsyncImage(
                model = product.image,
                contentDescription = product.title,
                modifier = Modifier.fillMaxWidth()
            )

            Text(text = product.title)
            Text(text = "${product.price} ₺")

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(onClick = onAddToCart) {
                    Text("Sepete Ekle")
                }

                IconButton(onClick = onAddToFavorites) {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "Favoriye Ekle"
                    )
                }
            }
        }
    }
}