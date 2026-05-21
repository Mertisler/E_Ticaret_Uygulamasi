package com.loc.eticaretuygulamasi.feature.cart.presentation.data

import com.loc.eticaretuygulamasi.feature.cart.presentation.domain.model.CartItem
import com.loc.eticaretuygulamasi.feature.cart.presentation.domain.repository.CartRepository
import com.loc.eticaretuygulamasi.feature.product.domain.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class CartRepositoryImpl @Inject constructor()  : CartRepository {

    private val _cartItems =
        MutableStateFlow<List<CartItem>>(emptyList())

    override val cartItems =
        _cartItems.asStateFlow()

    override fun addToCart(product: Product) {

        val currentItems = _cartItems.value.toMutableList()

        val existingItem =
            currentItems.find { it.id == product.id }

        if(existingItem != null) {

            val updated =
                currentItems.map {

                    if(it.id == product.id) {
                        it.copy(quantity = it.quantity + 1)
                    } else it
                }

            _cartItems.value = updated

        } else {

            currentItems.add(
                CartItem(
                    id = product.id,
                    title = product.title,
                    price = product.price,
                    image = product.image,
                    quantity = 1
                )
            )

            _cartItems.value = currentItems
        }
    }

    override fun removeFromCart(id: Int) {
        TODO("Not yet implemented")
    }

    override fun increaseQuantity(id: Int) {
        TODO("Not yet implemented")
    }

    override fun decreaseQuantity(id: Int) {
        TODO("Not yet implemented")
    }
}