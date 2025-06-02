package com.example.products.data.remote

import com.example.products.data.model.Product

interface IProductRemoteDataSource {
    suspend fun makeNetworkCall() :List<Product>?
}