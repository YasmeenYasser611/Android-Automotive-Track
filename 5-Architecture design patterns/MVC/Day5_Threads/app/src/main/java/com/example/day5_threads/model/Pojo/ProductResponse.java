package com.example.day5_threads.model.Pojo;

import java.util.List;

public class ProductResponse {
    private List<Product> products;
    private static ProductResponse productResponse = null;

    private ProductResponse ()
    {

    }
    public static ProductResponse getInstance()
    {
        if(productResponse == null)
        {
            productResponse = new ProductResponse();
        }
        return productResponse;
    }
    public List<Product> getProducts() {
        return products;
    }


    public void Remove(Product product)
    {
        products.remove(product);
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}