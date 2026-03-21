package com.the.marketplace.ui.cart

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.the.marketplace.domain.model.CartModel
import com.the.marketplace.domain.usecase.ClearCartUseCase
import com.the.marketplace.domain.usecase.DeleteCartUseCase
import com.the.marketplace.domain.usecase.GetCartUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val cartUseCase: GetCartUseCase,
    private val deleteCartUseCase: DeleteCartUseCase,
    private val clearCartUseCase: ClearCartUseCase,
): ViewModel(){



    val cart = cartUseCase.invoke().stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        emptyList()
    )


     fun deleteItem(item: CartModel){
        viewModelScope.launch {
            try {
                deleteCartUseCase.invoke(item)
            }catch (e:Exception){
                Log.e("API_ERROR", e.message.toString())
            }
        }
    }

    fun clearCart(){
        viewModelScope.launch {
            try {
                clearCartUseCase.invoke()
            }catch (e:Exception){
                Log.e("API_ERROR", e.message.toString())
            }
        }
    }


}

