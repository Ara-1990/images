package com.the.marketplace.data.repository

import com.the.marketplace.data.db.CartDao
import com.the.marketplace.data.db.CartEntity
import com.the.marketplace.data.mapper.toDomain
import com.the.marketplace.domain.model.CartModel
import com.the.marketplace.domain.model.Product
import com.the.marketplace.domain.repository.CartRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CartRepositoryImplem(private val dao: CartDao): CartRepository {

    override suspend fun addToCart(item: Product) {
        dao.insert(
            CartEntity(
                name = item.title,
                image = item.image
            )
        )
    }

    override fun getAll(): Flow<List<CartModel>> {

        return dao.getAll().map { entityList -> entityList.map { entity ->entity.toDomain() } }
    }


   override suspend fun clearCart() {
        dao.clearCart()
    }

    override suspend fun deleteItem(item: CartModel) {

        dao.delete(
            CartEntity(
                id = item.id,
                name = item.name,
                image = item.image
            )
        )
    }
}