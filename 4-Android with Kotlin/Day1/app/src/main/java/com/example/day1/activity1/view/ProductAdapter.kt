package com.example.day1.activity1.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.day1.R
import com.example.day1.model.Product
import com.example.day1.utils.ProductDiffUtill

class ProductAdapter(var myListener :(Product) -> Unit):ListAdapter<Product , ProductAdapter.ProuctViewHolder> (ProductDiffUtill())
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProuctViewHolder {
        val inflater:LayoutInflater=LayoutInflater.from(parent.context)
        val view= inflater.inflate(R.layout.list_item ,parent , false)
        return ProuctViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProuctViewHolder, position: Int) {
        val currentObj = getItem(position)
        holder.Image.setImageResource(currentObj.thumbnail)
        holder.Name.setText(currentObj.tittle)
        holder.Layout.setOnClickListener {
            myListener.invoke(currentObj)
        }
    }
    class ProuctViewHolder(private val item :View):RecyclerView.ViewHolder(item)
    {
        val Image :ImageView = item.findViewById(R.id.productImage)
        val Name: TextView = item.findViewById(R.id.productName)
        val Layout : LinearLayout = item.findViewById(R.id.itemlayout)


    }
}