package com.loc.eticaretuygulamasi.feature.favorite.domain.repository

import com.loc.eticaretuygulamasi.feature.favorite.domain.model.FavoriteItem
import kotlinx.coroutines.flow.StateFlow

interface FavoriteRepository {
    val favoriteItems: StateFlow<List<FavoriteItem>>

    fun addToFavorites(item: FavoriteItem)

    fun removeFromFavorites(id: Int)
}