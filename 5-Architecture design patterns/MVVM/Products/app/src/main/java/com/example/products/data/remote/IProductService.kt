package com.example.day1.model.remote

import com.example.products.data.model.ProductResponse
import retrofit2.Response
import retrofit2.http.GET


interface IProductService {
    @GET("products")
    suspend fun getProducts(): Response<ProductResponse?>?
}