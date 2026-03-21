package com.the.marketplace.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.the.marketplace.domain.model.Product
import com.the.marketplace.ui.ditalilscreen.ProductDetailScreen
import com.the.marketplace.ui.home.HomeScreen
import com.the.marketplace.ui.cart.CartScreen
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.outlined.AddShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.the.marketplace.ui.cart.CartViewModel


@Composable
fun NavGraph(cartViewModel: CartViewModel = hiltViewModel()) {

    val navController = rememberNavController()

    val cartItems by cartViewModel.cart.collectAsState()

    Scaffold(
        bottomBar = {

            NavigationBar {
                NavigationBarItem(
                    selected = false,
                    onClick = {
                        navController.navigate("home") {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true; restoreState = true
                        }
                    },

                    icon = { Icon(Icons.Outlined.Home, null) },

                    )

                NavigationBarItem(
                    selected = false,
                    onClick = {
                        navController.navigate("cart") {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true; restoreState = true
                        }
                    },

                    icon = {
                        BadgedBox(
                            badge = {
                                if (cartItems.isNotEmpty()) {
                                    Badge {
                                        Text(cartItems.size.toString())
                                    }
                                }
                            }
                        ) {
                            Icon(Icons.Outlined.AddShoppingCart, null)

                        }
                    },

                    )


            }
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(padding)
        ) {
            composable("home") {
                HomeScreen(navController)
            }

            composable(route = "detail") {

                val product =
                    navController.previousBackStackEntry
                        ?.savedStateHandle
                        ?.get<Product>("product")


                ProductDetailScreen(product)

            }
            composable("cart") {
                CartScreen(navController)
            }


        }
    }


}