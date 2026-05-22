package com.loc.eticaretuygulamasi.feature.favorite.presentation

import androidx.lifecycle.ViewModel
import com.loc.eticaretuygulamasi.feature.favorite.domain.model.FavoriteItem
import com.loc.eticaretuygulamasi.feature.favorite.domain.repository.FavoriteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val favoriteRepository: FavoriteRepository
) : ViewModel() {

    val favoriteItems = favoriteRepository.favoriteItems

    fun addToFavorites(item: FavoriteItem) {
        favoriteRepository.addToFavorites(item)
    }

    fun removeFromFavorites(id: Int) {
        favoriteRepository.removeFromFavorites(id)
    }

}