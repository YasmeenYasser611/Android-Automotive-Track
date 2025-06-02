package com.example.products.data.remote

import com.example.day1.model.remote.IProductService
import com.example.products.data.model.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductRemoteDataSourceImpl(private val  productService:IProductService):IProductRemoteDataSource {
    override suspend fun makeNetworkCall(): List<Product>? {
        return withContext(Dispatchers.IO)
        {
            productService.getProducts()?.body()?.products
        }
    }
}