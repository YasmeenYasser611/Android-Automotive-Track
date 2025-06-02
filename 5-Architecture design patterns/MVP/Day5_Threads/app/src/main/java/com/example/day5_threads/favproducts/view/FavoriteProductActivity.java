package com.example.day5_threads.favproducts.view;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day5_threads.R;
import com.example.day5_threads.allproducts.presenter.AllProductsPresenter;
import com.example.day5_threads.favproducts.presenter.FavoritePresenter;
import com.example.day5_threads.model.Local.ProductDao;
import com.example.day5_threads.model.Local.ProductDataBase;
import com.example.day5_threads.model.Pojo.Product;
import com.example.day5_threads.model.Pojo.ProductRepository;
import com.example.day5_threads.model.Remote.ProductClient;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class FavoriteProductActivity extends AppCompatActivity implements OnFavoriteRemoveClickListener , FavoriteProductView {

    private RecyclerView recyclerView;
    private FavoriteProductAdaptor adapter;


    FavoritePresenter favoritePresenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fav_list);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        favoritePresenter = new FavoritePresenter(this, ProductRepository.getInstance(ProductClient.getInstance(), ProductDataBase.gatInstance(this).getProductDao()));


        LiveData<List<Product>> productList = favoritePresenter.getProducts();
        productList.observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                adapter = new FavoriteProductAdaptor(FavoriteProductActivity.this, products, FavoriteProductActivity.this);
                recyclerView.setAdapter(adapter);
            }
        });
    }

    @Override
    public void onFavRemoveProductClick(Product product)
    {

        favoritePresenter.removeFromFav(product);

        // Show Snackbar with undo action
        Snackbar snackbar = Snackbar.make(
                recyclerView,
                "Item removed",
                Snackbar.LENGTH_LONG
        );

        snackbar.setAction("UNDO", v -> {
            favoritePresenter.addToFav(product);
        });

        snackbar.show();
    }


    @Override
    public void ShowData(List<Product> products) {

    }

    @Override
    public void ShowErrMsg(String error) {

    }
}

