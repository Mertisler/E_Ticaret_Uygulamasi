package com.loc.eticaretuygulamasi.feature.product.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.loc.eticaretuygulamasi.feature.cart.presentation.domain.repository.CartRepository
import com.loc.eticaretuygulamasi.feature.favorite.domain.model.FavoriteItem
import com.loc.eticaretuygulamasi.feature.favorite.domain.repository.FavoriteRepository
import com.loc.eticaretuygulamasi.feature.product.domain.model.Product
import com.loc.eticaretuygulamasi.feature.product.domain.usecase.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    getProductsUseCase: GetProductsUseCase,
    private val favoriteRepository: FavoriteRepository,
    private val cartRepository: CartRepository
) : ViewModel() {

    fun addToFavorites(product: Product) {
        val favoriteItem = FavoriteItem(
            id = product.id,
            title = product.title,
            price = product.price,
            image = product.image
        )
        favoriteRepository.addToFavorites(favoriteItem)
    }

    fun addToCart(product: Product) {
        cartRepository.addToCart(product)
    }

    val products =
        getProductsUseCase()
            .cachedIn(viewModelScope)
}