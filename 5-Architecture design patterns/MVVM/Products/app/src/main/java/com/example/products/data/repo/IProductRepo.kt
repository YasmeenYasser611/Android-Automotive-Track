package com.example.products.data.repo

import com.example.products.data.model.Product

interface IProductRepo {
    suspend fun getProduct(flag:Boolean) : List<Product>?

    suspend fun insertProduct(product: Product)

    suspend fun deleteProduct(product: Product)
}