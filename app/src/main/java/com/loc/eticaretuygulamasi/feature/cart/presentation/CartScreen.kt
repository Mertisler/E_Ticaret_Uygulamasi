package com.loc.eticaretuygulamasi.feature.cart.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.loc.eticaretuygulamasi.feature.cart.presentation.presenetation.CartViewModel

@Composable
fun CartScreen(
    viewModel: CartViewModel = hiltViewModel()
) {
    // Repository'den gelen canlı veriyi dinliyoruz
    val cartItems by viewModel.cartItems.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Sepetim", fontWeight = FontWeight.Bold)
        Divider(modifier = Modifier.padding(vertical = 8.dp))

        if (cartItems.isEmpty()) {
            Text(text = "Sepetiniz şu an boş.")
        } else {
            LazyColumn {
                items(cartItems) { item ->
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = item.title, modifier = Modifier.weight(1f))
                        Text(text = "Adet: ${item.quantity}")
                        Text(text = "${item.price * item.quantity} ₺")
                    }
                }
            }
        }
    }
}