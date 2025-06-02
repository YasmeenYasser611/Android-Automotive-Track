package com.example.products.features.allproducts.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.products.data.repo.IProductRepo


class AllProductViewModelFactory(private val repo: IProductRepo): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AllProductViewModel(repo) as T
    }
}