package com.genesis.domain.repository

import com.genesis.domain.models.Product

interface ProductRepository {
    suspend fun getProducts(): List<Product>
}
