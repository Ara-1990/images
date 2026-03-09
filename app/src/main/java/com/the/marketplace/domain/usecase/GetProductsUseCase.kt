package com.the.marketplace.domain.usecase

import com.the.marketplace.domain.model.Product
import com.the.marketplace.domain.repository.ProductRepository
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(private val repository: ProductRepository) {

    suspend operator fun invoke(query: String): List<Product> {
        return repository.getProducts(query)
    }
}