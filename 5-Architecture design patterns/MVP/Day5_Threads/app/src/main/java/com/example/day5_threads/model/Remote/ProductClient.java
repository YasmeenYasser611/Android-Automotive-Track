package com.example.day5_threads.model.Remote;

import com.example.day5_threads.model.Pojo.ProductResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductClient
{


    private static final String BASE_URL = "https://dummyjson.com/";

    private static ProductClient client = null;

    ProductService productService;

    private ProductClient()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        productService= retrofit.create(ProductService.class);
    }

    public static ProductClient getInstance()
    {
        if(client == null)
        {
            client = new ProductClient();
        }
        return  client;
    }

    public void makeNetworkCall(NetworkCallBack networkCallBack)
    {
        productService.getProducts().enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                if(response.isSuccessful() && response.body() != null)
                {
                    networkCallBack.OnSuccessResult(response.body().getProducts());

                }
                else
                {
                    networkCallBack.OnFailuerResult(response.message());

                }
            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t)
            {
                networkCallBack.OnFailuerResult(t.getMessage());


            }
        });
    }


}
