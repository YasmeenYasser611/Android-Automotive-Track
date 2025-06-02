package com.example.day1.model

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ProductClient
private constructor() {
    var productService: ProductService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        productService = retrofit.create<ProductService>(ProductService::class.java)
    }

    fun makeNetworkCall() :List<Product>?
    {
       return productService.getProducts()?.execute()?.body()?.products

    }


    companion object {
        private const val BASE_URL = "https://dummyjson.com/"

        private var client: ProductClient? = null

        val instance: ProductClient?
            get() {
                if (client == null) {
                    client = ProductClient()
                }
                return client
            }
    }
}