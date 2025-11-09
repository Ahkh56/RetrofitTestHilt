package com.genesis.feature_home.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.genesis.core.common.Resource
import com.genesis.domain.models.Product
import com.genesis.domain.use_case.GetProductsUseCase
import com.genesis.feature_home.presentation.state.ProductListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(ProductListState())
    val state: State<ProductListState> = _state

    init {
        getProducts()
    }

    private fun getProducts() {
        val productsFlow: Flow<Resource<List<Product>>> = getProductsUseCase()
        productsFlow.onEach {
            result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = _state.value.copy(
                        products = result.data ?: emptyList(),
                        isLoading = false
                    )
                }
                is Resource.Error<*> -> {
                    _state.value = _state.value.copy(
                        error = result.message ?: "An unexpected error occurred",
                        isLoading = false
                    )
                }
                is Resource.Loading<*> -> {
                    _state.value = _state.value.copy(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
