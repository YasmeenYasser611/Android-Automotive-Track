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


class ProductAdapter(var myListener :(Product) -> Unit):ListAdapter<Product, ProductAdapter.ProuctViewHolder> (ProductDiffUtill())
{
    lateinit var context :Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProuctViewHolder {
        val inflater:LayoutInflater=LayoutInflater.from(parent.context)
        val view= inflater.inflate(R.layout.list_item ,parent , false)
        context= parent.context
        return ProuctViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProuctViewHolder, position: Int) {
        val currentObj = getItem(position)
//        holder.Image.setImageResource(currentObj.thumbnail)
        holder.Name.text = currentObj.title
        holder.Layout.setOnClickListener {
            myListener.invoke(currentObj)
        }
        Glide.with(context)
            .load(currentObj.thumbnail)
            .apply(
                RequestOptions()
                    .override(200, 200)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_foreground)
            )
            .into(holder.Image)
    }
    class ProuctViewHolder(private val item :View):RecyclerView.ViewHolder(item)
    {
        val Image :ImageView = item.findViewById(com.example.day1.R.id.productImage)
        val Name: TextView = item.findViewById(R.id.productName)
        val Layout : LinearLayout = item.findViewById(R.id.itemlayout)


    }
}