package com.the.marketplace.domain.usecase


import com.the.marketplace.domain.repository.CartRepository
import javax.inject.Inject

class ClearCartUseCase @Inject constructor (private val repository: CartRepository) {

    suspend  operator fun invoke() {
        return repository.clearCart()
    }
}