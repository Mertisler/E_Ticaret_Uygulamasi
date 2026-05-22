package com.loc.eticaretuygulamasi.feature.favorite.data

import com.loc.eticaretuygulamasi.feature.favorite.domain.model.FavoriteItem
import com.loc.eticaretuygulamasi.feature.favorite.domain.repository.FavoriteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class FavoriteRepositoryImpl @Inject constructor() : FavoriteRepository {


        private val _favoriteItems = MutableStateFlow<List<FavoriteItem>>(emptyList())

    override val favoriteItems: StateFlow<List<FavoriteItem>>
        get() = _favoriteItems.asStateFlow()

    override fun addToFavorites(item: FavoriteItem) {
        val currentList = _favoriteItems.value.toMutableList()
        if (currentList.none { it.id == item.id }) {
            currentList.add(item)
            _favoriteItems.value = currentList
        }
    }


    override fun removeFromFavorites(id: Int) {
        val currentList = _favoriteItems.value.toMutableList()
        currentList.removeAll { it.id == id }
        _favoriteItems.value = currentList
    }
}