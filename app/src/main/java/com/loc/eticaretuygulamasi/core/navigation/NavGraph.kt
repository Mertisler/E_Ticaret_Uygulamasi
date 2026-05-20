package com.loc.eticaretuygulamasi.core.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import com.loc.eticaretuygulamasi.feature.auth.presentation.login.LoginScreen
import com.loc.eticaretuygulamasi.feature.auth.presentation.register.RegisterScreen
import com.loc.eticaretuygulamasi.feature.cart.prensetation.CartScreen
import com.loc.eticaretuygulamasi.feature.checkout.CheckoutScreen
import com.loc.eticaretuygulamasi.feature.favorite.presentation.FavoriteScreen
import com.loc.eticaretuygulamasi.feature.product.presentation.ProductDetailScreen
import com.loc.eticaretuygulamasi.feature.product.presentation.ProductListScreen
import com.loc.eticaretuygulamasi.feature.profile.presentation.ProfileScreen

@Composable
fun NavGraph() {

    val navController =
        rememberNavController()

    Scaffold(

        bottomBar = {

            NavigationBar {

                val currentRoute =
                    navController.currentBackStackEntryAsState()
                        .value
                        ?.destination
                        ?.route

                bottomBarItems.forEach { item ->

                    NavigationBarItem(

                        selected =
                            currentRoute == item.route,

                        onClick = {

                            navController.navigate(
                                item.route
                            )
                        },

                        icon = {

                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.title
                            )
                        },

                        label = {
                            Text(item.title)
                        }
                    )
                }
            }
        }

    ) { paddingValues ->

        NavHost(

            navController = navController,

            startDestination =
                Screen.Login.route,

            modifier =
                Modifier.padding(paddingValues)

        ) {

            composable(
                route = Screen.Login.route
            ) {

                LoginScreen()
            }

            composable(
                route = Screen.Register.route
            ) {

                RegisterScreen()
            }

            composable(
                route = Screen.ProductList.route
            ) {

                ProductListScreen()
            }

            composable(
                route = Screen.ProductDetail.route
            ) {

                ProductDetailScreen()
            }

            composable(
                route = Screen.Cart.route
            ) {

                CartScreen()
            }

            composable(
                route = Screen.Favorite.route
            ) {

                FavoriteScreen()
            }

            composable(
                route = Screen.Profile.route
            ) {

                ProfileScreen()
            }

            composable(
                route = Screen.Checkout.route
            ) {

                CheckoutScreen()
            }
        }
    }
}