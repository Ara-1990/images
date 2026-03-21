package com.the.marketplace.domain.usecase

import com.the.marketplace.domain.model.Product
import com.the.marketplace.domain.repository.CartRepository
import javax.inject.Inject

class SendImagetoDatabasUseCase @Inject constructor(private val repository: CartRepository) {

    suspend operator fun invoke(query: Product) {
        return repository.addToCart(query)
    }
}