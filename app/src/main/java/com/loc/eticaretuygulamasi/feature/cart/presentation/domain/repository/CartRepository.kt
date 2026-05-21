package com.loc.eticaretuygulamasi.feature.cart.presentation.domain.repository

import com.loc.eticaretuygulamasi.feature.cart.presentation.domain.model.CartItem
import com.loc.eticaretuygulamasi.feature.product.domain.model.Product
import kotlinx.coroutines.flow.StateFlow

interface CartRepository {

    val cartItems: StateFlow<List<CartItem>>

    fun addToCart(product: Product)

    fun removeFromCart(id: Int)

    fun increaseQuantity(id: Int)

    fun decreaseQuantity(id: Int)
}