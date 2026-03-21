package com.the.marketplace.domain.repository

import com.the.marketplace.domain.model.CartModel
import com.the.marketplace.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface CartRepository {
    suspend fun addToCart(item: Product)

    fun getAll(): Flow<List<CartModel>>

    suspend fun deleteItem(item: CartModel)

    suspend fun clearCart()
}