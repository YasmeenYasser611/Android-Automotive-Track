package com.example.day5_threads.allproducts.presenter;

import com.example.day5_threads.allproducts.view.AllProductView;
import com.example.day5_threads.model.Pojo.Product;
import com.example.day5_threads.model.Pojo.ProductRepository;
import com.example.day5_threads.model.Remote.NetworkCallBack;

import java.util.List;

public class AllProductsPresenter implements NetworkCallBack {

    private AllProductView _view;
    private ProductRepository _repo;

    public AllProductsPresenter(AllProductView _view , ProductRepository _repo)
    {
        this._repo= _repo;
        this._view = _view ;
    }

    public void getProducts()
    {
        _repo.getAllProducts(this);
    }

    public void addToFav(Product product)
    {
        _repo.insertProduct(product);

    }

    @Override
    public void OnSuccessResult(List<Product> product)
    {
        _view.ShowData(product);

    }

    @Override
    public void OnFailuerResult(String errormsg) {
        _view.ShowErrMsg(errormsg);

    }
}
