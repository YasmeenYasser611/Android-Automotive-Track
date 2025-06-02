package com.example.day1.activity1.view

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.day1.R
import com.example.day1.databinding.FragmentProductsBinding
import com.example.day1.model.local.LocalDatabase
import com.example.day1.model.local.ProductDao
import com.example.day1.model.remote.Product
import com.example.day1.model.remote.ProductClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ProductListFragment : Fragment()
{
    lateinit var communicator : Communicator

    lateinit var client : ProductClient

//    lateinit var recyclerView:RecyclerView
    lateinit var ProductAdapter : ProductAdapter
    private var productArray: List<Product> = emptyList()
    lateinit var binding : FragmentProductsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        return inflater.inflate(R.layout.fragment_products, container, false)
        binding = FragmentProductsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)


        communicator= activity as Communicator
//        recyclerView=  view.findViewById(R.id.productsRecyclerView)
        ProductAdapter = ProductAdapter {
            communicator.ShowProductDetails(it)
        }

        //instade of recyclerView.apply

        binding.productsRecyclerView.apply {
            adapter = ProductAdapter
            layoutManager = LinearLayoutManager(requireContext()).apply {
                orientation=RecyclerView.VERTICAL
            }
        }

        ProductAdapter.submitList(productArray)

        val productsDao :ProductDao = LocalDatabase.getInstance(requireContext()).getProductDao()

        val connectivityManager = requireContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkCapabilities = connectivityManager.activeNetwork?.let {
            connectivityManager.getNetworkCapabilities(it)
        }

        val isConnected = networkCapabilities?.let {
            it.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                    it.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
        } ?: false

        if(isConnected)
        {
            lifecycleScope.launch(Dispatchers.IO) {
                try {
                    client = ProductClient.instance!!

                    productArray= client.makeNetworkCall()!!
                    productsDao.insertAllProducts(productArray)

                    withContext(Dispatchers.Main)
                    {
                        ProductAdapter.submitList(productArray)
                    }



                }catch (th : Throwable)
                {
                    Log.i("TAG", th.message?:"Error ")

                }
            }

        }
        else
        {

            lifecycleScope.launch(Dispatchers.IO) {
                try {

                    productArray= productsDao.getAllProducts()

                    withContext(Dispatchers.Main)
                    {
                        ProductAdapter.submitList(productArray)
                    }

                }catch (th : Throwable)
                {
                    Log.i("TAG", th.message?:"Error ")

                }
            }


        }


    }


}