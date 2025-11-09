package com.genesis.data.repository

import com.genesis.data.remote.ApiService
import com.genesis.domain.models.Product
import com.genesis.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : ProductRepository {
    override suspend fun getProducts(): List<Product> {
        return apiService.getProducts()
    }
}
