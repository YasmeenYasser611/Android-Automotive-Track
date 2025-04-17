package com.example.day5_threads.favproducts.view;

import com.example.day5_threads.model.Pojo.Product;

import java.util.List;

public interface FavoriteProductView {
    public void ShowData(List<Product> products);

    public void ShowErrMsg(String error);
}
