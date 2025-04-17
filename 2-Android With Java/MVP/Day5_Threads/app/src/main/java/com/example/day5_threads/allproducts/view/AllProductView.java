package com.example.day5_threads.allproducts.view;

import com.example.day5_threads.model.Pojo.Product;

import java.util.List;

public interface AllProductView {
     void ShowData(List<Product> products);

     void ShowErrMsg(String error);
}
