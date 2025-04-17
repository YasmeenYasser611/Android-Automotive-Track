package com.example.day5_threads.favproducts.controller;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day5_threads.R;
import com.example.day5_threads.favproducts.view.FavAdapter;
import com.example.day5_threads.favproducts.view.OnFavoriteRemoveClickListener;
import com.example.day5_threads.model.DB.ProductDao;
import com.example.day5_threads.model.DB.ProductDataBase;
import com.example.day5_threads.model.Pojo.Product;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class FavActivity extends AppCompatActivity implements OnFavoriteRemoveClickListener {

    private RecyclerView recyclerView;
    private FavAdapter adapter;
    private ProductDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fav_list);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ProductDataBase db = ProductDataBase.gatInstance(this);
        dao = db.getProductDao();

        LiveData<List<Product>> productList = dao.getAllItems();
        productList.observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                adapter = new FavAdapter(FavActivity.this, products, FavActivity.this);
                recyclerView.setAdapter(adapter);
            }
        });
    }

    @Override
    public void onFavRemoveProductClick(Product product)
    {

        new Thread(() -> {
            dao.deleteItem(product);
        }).start();
        adapter.notifyDataSetChanged();

        // Show Snackbar with undo action
        Snackbar snackbar = Snackbar.make(
                findViewById(android.R.id.content),
                "Item removed",
                Snackbar.LENGTH_LONG
        );

        snackbar.setAction("UNDO", v -> {
            // Undo the deletion
            new Thread(() -> {
                dao.insertItem(product);
            }).start();
            adapter.notifyDataSetChanged();
        });

        snackbar.show();
    }



}

