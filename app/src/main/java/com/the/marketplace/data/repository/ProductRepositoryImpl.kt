package com.the.marketplace.data.repository

import com.the.marketplace.BuildConfig
import com.the.marketplace.data.mapper.toProduct
import com.the.marketplace.data.remote.PixabayApi
import com.the.marketplace.domain.model.Product
import com.the.marketplace.domain.repository.ProductRepository

class ProductRepositoryImpl (private val api: PixabayApi): ProductRepository{

    override suspend fun getProducts(query: String): List<Product> {
        val response = api.searchImages( query = query)
        return response.hits.map { it.toProduct() }
    }
}