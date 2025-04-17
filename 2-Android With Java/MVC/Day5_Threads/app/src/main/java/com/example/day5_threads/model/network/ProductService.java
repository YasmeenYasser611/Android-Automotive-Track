package com.example.day5_threads.model.network;

import com.example.day5_threads.model.Pojo.ProductResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductService {
    @GET("products")
    Call<ProductResponse> getProducts();
}
