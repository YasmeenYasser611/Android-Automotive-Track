package com.example.day5_threads.allproducts.controller;

//import static com.google.android.material.button.MaterialButtonToggleGroup.CornerData.start;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day5_threads.allproducts.view.OnFavoriteClickListener;
import com.example.day5_threads.R;
import com.example.day5_threads.allproducts.view.ProductAdapter;
import com.example.day5_threads.model.DB.ProductDao;
import com.example.day5_threads.model.DB.ProductDataBase;
import com.example.day5_threads.model.Pojo.Product;
import com.example.day5_threads.model.Pojo.ProductResponse;
import com.example.day5_threads.model.network.NetworkCallBack;
import com.example.day5_threads.model.network.ProductClient;

import java.util.List;

import okhttp3.Cache;
import okhttp3.OkHttpClient;

public class MainMenuActivity extends AppCompatActivity implements NetworkCallBack, OnFavoriteClickListener {

    private static final String TAG = "AllProducts";
    private static final String BASE_URL = "https://dummyjson.com/";
    private RecyclerView recyclerView;
    private RecyclerView recyclerView2;
    private ProductAdapter adapter;
    ProductAdapter AllProductAdapter;
    ProductClient productClient;

    ProductResponse repo ;
    ProductDao dao;

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





        ProductDataBase db = ProductDataBase.gatInstance(this);
        dao = db.getProductDao();

       // Product dummy = new Product(1, "title", "description", 50000.5, 1.5, "thumbnail");


        /*new Thread(() -> dao.insertItem(dummy)).start();*/

       /* new Thread()
        {
            @Override
            public void run() {
                dao.deleteItem(dummy);

            }
        }.start();*/



        productClient = ProductClient.getInstance();
        productClient.makeNetworkCall(this);


    }

    @Override
    public void OnSuccessResult(List<Product> product)
    {
        Log.i(TAG, "onResponse: " + product);
        AllProductAdapter= new ProductAdapter(MainMenuActivity.this, product , this);
        recyclerView.setAdapter(AllProductAdapter);


    }

    @Override
    public void OnFailuerResult(String errormsg)
    {
        Log.i(TAG, "onResponse: " + errormsg);
        Toast.makeText(MainMenuActivity.this, "Error: " + errormsg, Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onFavProductClick(Product product)
    {
        new Thread(() -> dao.insertItem(product)).start();


    }
}