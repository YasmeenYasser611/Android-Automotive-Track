package com.example.day1.activity1.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.example.day1.R
import com.example.day1.model.Product
import com.example.day1.work.ProductWork
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class ProductListFragment : Fragment()
{
    lateinit var communicator : Communicator


    lateinit var recyclerView:RecyclerView
    lateinit var ProductAdapter : ProductAdapter
    private var productArray: List<Product> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_products, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)


        communicator= activity as Communicator
        recyclerView=  view.findViewById(R.id.productsRecyclerView)
        ProductAdapter = ProductAdapter {
            communicator.ShowProductDetails(it)
        }
        recyclerView.apply {
            adapter = ProductAdapter
            layoutManager = LinearLayoutManager(requireContext()).apply {
                orientation=RecyclerView.VERTICAL
            }
        }

        ProductAdapter.submitList(productArray)

        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val request = OneTimeWorkRequestBuilder<ProductWork>()
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(requireContext()).enqueue(request)

        val result : LiveData<WorkInfo> = (WorkManager.getInstance(requireContext())).getWorkInfoByIdLiveData(request.id)

        result.observe(viewLifecycleOwner) { WorkInfo ->
            when(WorkInfo.state)
            {
                androidx.work.WorkInfo.State.SUCCEEDED -> {
                    val json = WorkInfo.outputData.getString("ProductsJson")
                    if (json != null) {
                        val type = object : TypeToken<List<Product>>() {}.type
                        productArray = Gson().fromJson(json, type)
                        ProductAdapter.submitList(productArray)
                        Log.i("products", "onViewCreated: ")

                    }

                }
                androidx.work.WorkInfo.State.FAILED , androidx.work.WorkInfo.State.CANCELLED -> {
                    productArray = emptyList()
                    Log.i("Products", "Empty: ")

                }
                androidx.work.WorkInfo.State.ENQUEUED -> {}
                androidx.work.WorkInfo.State.RUNNING -> {}
                androidx.work.WorkInfo.State.BLOCKED -> {}

            }

        }


        ProductAdapter.submitList(productArray.toList())
    }


}