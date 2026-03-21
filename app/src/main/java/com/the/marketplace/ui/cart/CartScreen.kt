package com.the.marketplace.ui.cart


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage

@Composable
fun CartScreen(
    navController: NavController,
    cartViewModel: CartViewModel = hiltViewModel()

) {
    val cartItems by cartViewModel.cart.collectAsState()

    Column {

        Button(
            onClick = { cartViewModel.clearCart() }
        ) {
            Text("Clear Cart")
        }

        LazyColumn {

            items(cartItems) { item ->


                    AsyncImage(
                        model = item.image,
                        contentDescription = null,
                        modifier = Modifier.height(80.dp)
                    )

                    Text(
                        text = item.name,
                        fontSize = 20.sp
                    )
                    Button(
                        onClick = {
                            cartViewModel.deleteItem(item)
                        }
                    ) {
                        Text("Remove")
                    }

            }
        }
    }

}
