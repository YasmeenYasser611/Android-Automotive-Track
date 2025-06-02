package com.example.products.features.favourite.view

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.products.data.model.Product
import com.example.products.databinding.ListItemBinding
import com.example.products.features.allproducts.view.ProductDiffUtill


class FavAdapter(var myListener :(Product) -> Unit):
    ListAdapter<Product, FavAdapter.ProductViewHolder>(ProductDiffUtill())
{
    lateinit var context : Context

    lateinit var binding : ListItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        context= parent.context
        binding = ListItemBinding.inflate(inflater, parent, false)
        return ProductViewHolder(binding)


    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val currentObj = getItem(position)
        holder.binding.tittle.text = currentObj.title
        holder.binding.price.text = currentObj.price.toString()
        holder.binding.description.text = currentObj.description
        holder.binding.ratingBar.rating = currentObj.rating.toFloat()
        holder.binding.Del.setOnClickListener {
            myListener.invoke(currentObj)
        }
        Glide.with(context).load(currentObj.thumbnail).into(holder.binding.imgv);
    }

    class ProductViewHolder(var binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)
}