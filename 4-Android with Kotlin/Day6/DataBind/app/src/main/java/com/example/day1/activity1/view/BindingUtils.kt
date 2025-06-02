package com.example.day1.activity1.view

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.day1.R

@BindingAdapter("imagurl")
fun LoadImageGlide(view:ImageView , url:String)
{
    Glide.with(view.context)
            .load(url)
            .apply(
                RequestOptions()
                    .override(200, 200)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_foreground)
            )
            .into(view)

}