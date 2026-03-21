package com.the.marketplace.ui.ditalilscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.the.marketplace.domain.model.Product
import com.the.marketplace.domain.usecase.SendImagetoDatabasUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: SendImagetoDatabasUseCase): ViewModel(){

    fun addToCart(item: Product) {
        viewModelScope.launch {
            repository(item)
        }
    }
}