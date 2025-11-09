package com.genesis.feature_home.presentation.state

import com.genesis.domain.models.Product

data class ProductListState(
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val error: String = ""
)
