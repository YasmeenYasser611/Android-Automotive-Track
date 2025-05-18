package com.example.day1.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.day1.model.Product

class ProductDiffUtill:DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean
    {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean
    {
       return oldItem==newItem
    }
}