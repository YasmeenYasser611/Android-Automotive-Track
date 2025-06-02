package com.example.day5_threads.model.Remote;

import com.example.day5_threads.model.Pojo.Product;

import java.util.List;

public interface NetworkCallBack {

    public void OnSuccessResult(List<Product> product);
    public void OnFailuerResult(String errormsg);
}
