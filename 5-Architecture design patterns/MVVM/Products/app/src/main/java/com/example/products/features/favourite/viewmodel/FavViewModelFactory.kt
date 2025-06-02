package com.example.products.features.favourite.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.products.data.repo.IProductRepo
import com.example.products.features.allproducts.viewmodel.AllProductViewModel


class FavViewModelFactory(private val repo: IProductRepo): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FavViewModel(repo) as T
    }
}