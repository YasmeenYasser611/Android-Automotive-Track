package com.example.day5_threads.model.Pojo;

import androidx.lifecycle.LiveData;

import com.example.day5_threads.model.Local.ProductDao;
import com.example.day5_threads.model.Remote.NetworkCallBack;
import com.example.day5_threads.model.Remote.ProductClient;

import java.util.List;

public class ProductRepository {

    private ProductDao ProductLocalSource;
    private ProductClient ProductRemoteSource;

    private  static ProductRepository repo = null;

    public static ProductRepository getInstance(ProductClient remote , ProductDao local)
    {
        if(repo == null)
        {
            repo = new ProductRepository(remote , local);
        }
        return repo;

    }

    private ProductRepository(ProductClient remote , ProductDao local)
    {
        this.ProductLocalSource = local;
        this.ProductRemoteSource= remote;

    }

    public LiveData<List<Product>> getStoredProducts()
    {
        return ProductLocalSource.getAllItems();

    }

    public void getAllProducts(NetworkCallBack networkCallBack)
    {
        ProductRemoteSource.makeNetworkCall(networkCallBack);
    }

    public  void insertProduct(Product product)
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ProductLocalSource.insertItem(product);

            }
        }).start();

    }

    public void deleteProduct(Product product)
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ProductLocalSource.deleteItem(product);

            }
        }).start();

    }

}
