package com.example.products.data.local

import com.example.products.data.model.Product

interface IProuctLocalDataSource {

    suspend fun insertProduct(product: Product)

    suspend fun deleteProduct(product: Product)

    suspend fun getProduct(flag: Boolean) : List<Product>
}