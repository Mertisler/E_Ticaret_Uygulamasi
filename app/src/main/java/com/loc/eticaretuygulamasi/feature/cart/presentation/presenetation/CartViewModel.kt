package com.loc.eticaretuygulamasi.feature.cart.presentation.presenetation

import androidx.lifecycle.ViewModel
import com.loc.eticaretuygulamasi.feature.cart.presentation.domain.repository.CartRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val cartRepository: CartRepository
) : ViewModel() {

    val cartItems = cartRepository.cartItems

}