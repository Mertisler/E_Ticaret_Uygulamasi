package com.loc.eticaretuygulamasi.core.navigation

sealed class Screen(
    val route: String
) {

    data object Login : Screen("login")

    data object Register : Screen("register")

    data object ProductList :
        Screen("product_list")

    data object ProductDetail :
        Screen("product_detail")

    data object Cart :
        Screen("cart")

    data object Favorite :
        Screen("favorite")

    data object Profile :
        Screen("profile")

    data object Checkout :
        Screen("checkout")
}