package com.example.day1.activity2.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.day1.R
import com.example.day1.model.remote.Product


class Fragment2 : Fragment() {

    lateinit var Img :ImageView
    lateinit var Name:TextView
    lateinit var Description:TextView
    lateinit var Price:TextView
    lateinit var Rating :RatingBar



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        Img =view.findViewById(R.id.imgView)
        Name =view.findViewById(R.id.txtViewTitle)
        Description =view.findViewById(R.id.txtViewDesc)
        Price =view.findViewById(R.id.txtViewPrice)
        Rating =view.findViewById(R.id.ratingBar)





    }
    fun ShowProduct(product: Product)
    {
        if (view != null) {
//            Img.setImageResource(product.thumbnail)
            Name.setText(product.title)
            Description.setText(product.description)
            Price.text = product.price.toString()
            Rating.rating = product.rating.toFloat()

            Glide.with(requireContext())
                .load(product.thumbnail)
                .apply(
                    RequestOptions()
                        .override(200, 200)
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_foreground)
                )
                .into(Img)
        }


    }




}