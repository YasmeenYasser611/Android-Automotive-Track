package com.example.products.features.allproducts.view

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.day1.model.local.LocalDatabase
import com.example.day1.model.remote.IProductService
import com.example.products.R
import com.example.products.data.local.ProuctLocalDataSourceImpl
import com.example.products.data.model.Product
import com.example.products.data.remote.ProductRemoteDataSourceImpl
import com.example.products.data.remote.RetrofitHelper
import com.example.products.data.repo.IProductRepo
import com.example.products.data.repo.ProductsRepoImpl
import com.example.products.databinding.ProductsListBinding
import com.example.products.features.allproducts.viewmodel.AllProductViewModel
import com.example.products.features.allproducts.viewmodel.AllProductViewModelFactory
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AllProductsActivity : AppCompatActivity()
{



    lateinit var viewModel: AllProductViewModel
    lateinit var vmFactory: AllProductViewModelFactory
    lateinit var allProductsAdaptor: AllProductsAdaptor

    lateinit var binding : ProductsListBinding

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val connectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkCapabilities = connectivityManager.activeNetwork?.let {
            connectivityManager.getNetworkCapabilities(it)
        }
        val isConnected = networkCapabilities?.let {
            it.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                    it.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
        } ?: false

//        setContentView(R.layout.activity_main)

        binding = ProductsListBinding.inflate(layoutInflater)
        setContentView(binding.root)


        vmFactory= AllProductViewModelFactory(ProductsRepoImpl.getInstance(ProductRemoteDataSourceImpl(RetrofitHelper.retrofit.create(IProductService::class.java ) ), ProuctLocalDataSourceImpl(LocalDatabase.getInstance(this).getProductDao())))

        viewModel = ViewModelProvider(this , vmFactory).get(AllProductViewModel::class.java)
//        viewModel.getAllProducts()

        viewModel.getAllProducts(isConnected)

        allProductsAdaptor = AllProductsAdaptor { product ->
            viewModel.insertProduct(product)
        }

        binding.recyclerView.apply {
            adapter = allProductsAdaptor
            layoutManager = LinearLayoutManager(this@AllProductsActivity).apply {
                orientation=RecyclerView.VERTICAL
            }


            viewModel.onlineProducts.observe(this@AllProductsActivity){ products ->
                allProductsAdaptor.submitList(products)
            }

        }

    }
}