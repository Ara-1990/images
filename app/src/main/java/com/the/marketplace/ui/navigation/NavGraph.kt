package com.the.marketplace.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.the.marketplace.domain.model.Product
import com.the.marketplace.ui.ditalilscreen.ProductDetailScreen
import com.the.marketplace.ui.home.HomeScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
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

    }
}