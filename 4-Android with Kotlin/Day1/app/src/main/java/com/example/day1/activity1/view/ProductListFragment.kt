package com.example.day1.activity1.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.day1.R
import com.example.day1.model.Product


class ProductListFragment : Fragment()
{
    lateinit var communicator : Communicator


    lateinit var recyclerView:RecyclerView
    lateinit var ProductAdapter : ProductAdapter

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
        val productArray = arrayOf(
            Product(1, "Product 1", "Product1 Describtion", 1.5f , 1f , R.drawable.one ),
            Product(2, "Product 2", "Product2 Describtion", 2.5f , 2f , R.drawable.two ),
            Product(3, "Product 3", "Product3 Describtion", 3.5f , 3f, R.drawable.three ),
            Product(4, "Product 4", "Product4 Describtion", 4.5f, 4f, R.drawable.four ),
            Product(5, "Product 5", "Product5 Describtion", 5.5f, 5f , R.drawable.five )
        )
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


        ProductAdapter.submitList(productArray.toList())
    }


}