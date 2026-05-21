package com.loc.eticaretuygulamasi.feature.product.presentation
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.loc.eticaretuygulamasi.feature.product.domain.model.Product

@Composable
fun ProductItem(

    product: Product,

    onAddToCart: () -> Unit

) {

    Card(
        modifier = Modifier.padding(8.dp)
    ) {

        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            AsyncImage(
                model = product.image,
                contentDescription = product.title,
                modifier = Modifier.fillMaxWidth()
            )

            Text(
                text = product.title
            )

            Text(
                text = "${product.price} ₺"
            )

            Button(
                onClick = onAddToCart
            ) {
                Text("Sepete Ekle")
            }
        }
    }
}