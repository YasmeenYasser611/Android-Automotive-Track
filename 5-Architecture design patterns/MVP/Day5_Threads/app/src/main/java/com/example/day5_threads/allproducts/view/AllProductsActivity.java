package com.example.day5_threads.allproducts.view;

//import static com.google.android.material.button.MaterialButtonToggleGroup.CornerData.start;

import static com.example.day5_threads.model.Local.ProductDataBase.*;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day5_threads.R;
import com.example.day5_threads.allproducts.presenter.AllProductsPresenter;
import com.example.day5_threads.model.Local.ProductDao;
import com.example.day5_threads.model.Local.ProductDataBase;
import com.example.day5_threads.model.Pojo.Product;
import com.example.day5_threads.model.Pojo.ProductRepository;
import com.example.day5_threads.model.Pojo.ProductResponse;
import com.example.day5_threads.model.Remote.NetworkCallBack;
import com.example.day5_threads.model.Remote.ProductClient;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Cache;
import okhttp3.OkHttpClient;

public class AllProductsActivity extends AppCompatActivity implements AllProductView, OnFavoriteClickListener {

    private static final String TAG = "AllProducts";
    private static final String BASE_URL = "https://dummyjson.com/";
    private RecyclerView recyclerView;

    com.example.day5_threads.allproducts.view.AllProductAdapter AllProductAdapter;
//    ProductClient productClient;

    AllProductsPresenter ProductsPresenter;

//    ProductRepository repo ;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AllProductAdapter= new AllProductAdapter(AllProductsActivity.this, new ArrayList<>(), this);

//        repo = ProductRepository.getInstance(ProductClient.getInstance() , ProductDataBase.gatInstance(this).getProductDao());
        ProductsPresenter = new AllProductsPresenter(this , ProductRepository.getInstance(ProductClient.getInstance() , ProductDataBase.gatInstance(this).getProductDao()));

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));










        ProductsPresenter.getProducts();


    }





    @Override
    public void onFavProductClick(Product product)
    {
        ProductsPresenter.addToFav(product);


    }

    @Override
    public void ShowData(List<Product> products)
    {
        AllProductAdapter.SetList(products);
        recyclerView.setAdapter(AllProductAdapter);
        AllProductAdapter.notifyDataSetChanged();

    }

    @Override
    public void ShowErrMsg(String error) {
        Log.i(TAG, "onResponse: " + error);
        Toast.makeText(AllProductsActivity.this, "Error: " + error, Toast.LENGTH_SHORT).show();

    }
}