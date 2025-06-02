package com.example.products.features.allproducts.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.products.data.model.Product
import com.example.products.data.repo.IProductRepo
import kotlinx.coroutines.launch
import javax.security.auth.login.LoginException

class AllProductViewModel(private val _iRepo : IProductRepo): ViewModel() {
    private val _productList = MutableLiveData<List<Product>?>()
    val onlineProducts : LiveData<List<Product>?> = _productList


    private var _error:MutableLiveData<String> = MutableLiveData<String>()
    var errorMsg:LiveData<String> = _error


    init {
        getAllProducts(true)
    }

    fun getAllProducts(flag :Boolean)
    {
        try {
            viewModelScope.launch {
                val product = _iRepo.getProduct(flag)
                Log.i("TAG", "getAllProducts: $product")
                _productList.postValue(product)
            }

        }
        catch (ex: Exception)
        {
            _error.postValue(ex.message)

        }

    }

    fun insertProduct(product: Product)
    {
        viewModelScope.launch {
            _iRepo.insertProduct(product)
        }
    }




    override fun onCleared() {
        super.onCleared()
        Log.i("TAG", "onCleared: AllProducts ViewModel Cleared")
    }
}