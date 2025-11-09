package com.genesis.data.remote

import com.genesis.domain.models.Product
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getProducts(): List<Product>
}