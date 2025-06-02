package com.example.products.features.favourite.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.day1.model.local.LocalDatabase
import com.example.day1.model.remote.IProductService
import com.example.products.R
import com.example.products.data.local.ProuctLocalDataSourceImpl
import com.example.products.data.remote.ProductRemoteDataSourceImpl
import com.example.products.data.remote.RetrofitHelper
import com.example.products.data.repo.ProductsRepoImpl
import com.example.products.databinding.FavListBinding
import com.example.products.databinding.ProductsListBinding
import com.example.products.features.allproducts.view.AllProductsAdaptor
import com.example.products.features.allproducts.viewmodel.AllProductViewModel
import com.example.products.features.allproducts.viewmodel.AllProductViewModelFactory
import com.example.products.features.favourite.viewmodel.FavViewModel
import com.example.products.features.favourite.viewmodel.FavViewModelFactory

class FavActivity : AppCompatActivity() {

    lateinit var viewModel: FavViewModel
    lateinit var vmFactory: FavViewModelFactory
    lateinit var favAdaptor: FavAdapter

    lateinit var binding : FavListBinding

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        setContentView(R.layout.fav_list)
        binding = FavListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vmFactory= FavViewModelFactory(
            ProductsRepoImpl.getInstance(
                ProductRemoteDataSourceImpl(RetrofitHelper.retrofit.create(IProductService::class.java ) ), ProuctLocalDataSourceImpl(
                    LocalDatabase.getInstance(this).getProductDao())
            ))

        viewModel = ViewModelProvider(this@FavActivity , vmFactory).get(FavViewModel::class.java)
//        viewModel.getAllProducts()

        viewModel.getAllProducts()

        favAdaptor = FavAdapter { product ->
            viewModel.removeProduct(product)
            viewModel.getAllProducts()
        }

        binding.recyclerView.apply {
            adapter = favAdaptor
            layoutManager = LinearLayoutManager(this@FavActivity).apply {
                orientation= RecyclerView.VERTICAL
            }


            viewModel.onlineProducts.observe(this@FavActivity){ products ->
                favAdaptor.submitList(products)
            }

        }

    }
}