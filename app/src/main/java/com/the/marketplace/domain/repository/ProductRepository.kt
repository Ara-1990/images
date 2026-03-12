package com.the.marketplace.domain.repository

import com.the.marketplace.domain.model.Product

interface ProductRepository {
    suspend fun getProducts(query: String): List<Product>
}
