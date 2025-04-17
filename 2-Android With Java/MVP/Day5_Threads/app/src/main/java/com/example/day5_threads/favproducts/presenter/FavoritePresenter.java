package com.example.day5_threads.favproducts.presenter;

import androidx.lifecycle.LiveData;

import com.example.day5_threads.allproducts.view.AllProductView;
import com.example.day5_threads.favproducts.view.FavoriteProductView;
import com.example.day5_threads.model.Pojo.Product;
import com.example.day5_threads.model.Pojo.ProductRepository;
import com.example.day5_threads.model.Remote.NetworkCallBack;

import java.util.List;

public class FavoritePresenter  {

    private FavoriteProductView _view;
    private ProductRepository _repo;

    public FavoritePresenter(FavoriteProductView _view , ProductRepository _repo)
    {
        this._repo= _repo;
        this._view = _view ;
    }



    public void removeFromFav(Product product)
    {
        _repo.deleteProduct(product);
    }

    public void addToFav(Product product)
    {
        _repo.insertProduct(product);

    }

    public LiveData<List<Product>> getProducts()
    {
        return _repo.getStoredProducts();
    }


}
