package com.example.day5_threads;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String BASE_URL = "https://dummyjson.com/";
    private RecyclerView recyclerView;
    private ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int cashsize = 10*1024*1024;

        Cache cash = new Cache(getCacheDir() , cashsize);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cache(cash)
                .build();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ProductService service = retrofit.create(ProductService.class);

        service.getProducts().enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                if (response.isSuccessful() && response.body() != null)
                {
                    adapter = new ProductAdapter(MainActivity.this, response.body().getProducts());
                    recyclerView.setAdapter(adapter);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Failed to get products", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}