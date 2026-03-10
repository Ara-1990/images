package com.the.marketplace.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen (viewModel: HomeViewModel = hiltViewModel()){

    val products by viewModel.products.collectAsState()
    val query by viewModel.query.collectAsState()

    Column{
        SearchBar(
            query = query,
            onQueryChange = {
                viewModel.updateQuery(it)
            }
        )


        LazyVerticalGrid(
            columns = GridCells.Fixed(2)
        ) {

            items(products) { product ->

                ProductItem(product)

            }

        }
    }

}