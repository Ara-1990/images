package com.the.marketplace.domain.usecase

import com.the.marketplace.domain.model.CartModel
import com.the.marketplace.domain.repository.CartRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCartUseCase @Inject constructor (private val repository: CartRepository) {

     operator fun invoke(): Flow<List<CartModel>> {
        return repository.getAll()
    }
}