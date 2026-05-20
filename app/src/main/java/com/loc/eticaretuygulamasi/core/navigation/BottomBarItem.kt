package com.loc.eticaretuygulamasi.core.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomBarItem(

    val title: String,

    val icon: ImageVector,

    val route: String
)

val bottomBarItems = listOf(

    BottomBarItem(
        title = "Home",
        icon = Icons.Default.Home,
        route = Screen.ProductList.route
    ),

    BottomBarItem(
        title = "Cart",
        icon = Icons.Default.ShoppingCart,
        route = Screen.Cart.route
    ),

    BottomBarItem(
        title = "Favorite",
        icon = Icons.Default.Favorite,
        route = Screen.Favorite.route
    ),

    BottomBarItem(
        title = "Profile",
        icon = Icons.Default.Person,
        route = Screen.Profile.route
    )
)
