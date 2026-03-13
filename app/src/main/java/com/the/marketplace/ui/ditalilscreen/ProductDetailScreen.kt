package com.the.marketplace.ui.ditalilscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.the.marketplace.domain.model.Product

@Composable
fun ProductDetailScreen(productId: Product?) {

    productId?.let {

        Column(modifier = Modifier.fillMaxSize()) {

            AsyncImage(
                model = it.image,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp)
            )

            Text(
                text = it.title,
                fontSize = 20.sp
            )

            Text(
                text = "Likes: ${it.likes}"
            )


        }
    }
}