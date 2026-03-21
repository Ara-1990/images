package com.the.marketplace.domain.usecase

import com.the.marketplace.domain.model.CartModel
import com.the.marketplace.domain.repository.CartRepository
import javax.inject.Inject

class DeleteCartUseCase @Inject constructor (private val repository: CartRepository) {

   suspend  operator fun invoke(item: CartModel) {
        return repository.deleteItem(item)
    }
}