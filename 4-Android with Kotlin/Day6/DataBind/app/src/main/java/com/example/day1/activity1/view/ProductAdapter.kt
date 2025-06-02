package com.example.day1.activity1.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.day1.model.remote.Product
import com.example.day1.utils.ProductDiffUtill
import com.example.day1.R
import com.example.day1.databinding.ListItemBinding


class ProductAdapter(var myListener : ProductClickListener):ListAdapter<Product, ProductAdapter.ProuctViewHolder> (ProductDiffUtill())
{
    lateinit var context :Context

    lateinit var binding : ListItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProuctViewHolder {
        val inflater:LayoutInflater=LayoutInflater.from(parent.context)
        context= parent.context
        binding = ListItemBinding.inflate(inflater, parent, false)
        return ProuctViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProuctViewHolder, position: Int) {
        val currentObj = getItem(position)

        holder.binding.product = currentObj
        holder.binding.listener=myListener

    }


    class ProuctViewHolder(var binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)
}