package com.example.day1.model

import retrofit2.Call
import retrofit2.http.GET


interface ProductService {
    @GET("products")
    fun getProducts(): Call<ProductResponse?>?
}