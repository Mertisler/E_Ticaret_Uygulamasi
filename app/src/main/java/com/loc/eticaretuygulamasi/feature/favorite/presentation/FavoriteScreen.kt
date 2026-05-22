package com.loc.eticaretuygulamasi.feature.favorite.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun FavoriteScreen(
    viewModel: FavoriteViewModel = hiltViewModel()
) {
    val favoriteItems by viewModel.favoriteItems.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        if (favoriteItems.isEmpty()) {
            Text(text = "Favori ürününüz bulunmuyor.")
        } else {
            LazyColumn {
                items(favoriteItems) { item ->
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = item.title, modifier = Modifier.weight(1f))
                        Text(text = "${item.price} ₺")

                        Button(onClick = { viewModel.removeFromFavorites(item.id) }) {
                            Text("Kaldır")
                        }
                    }
                }
            }
        }
    }
}