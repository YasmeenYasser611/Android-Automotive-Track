package com.example.products.features.main.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.products.databinding.ActivityMainBinding
import com.example.products.features.allproducts.view.AllProductsActivity
import com.example.products.features.favourite.view.FavActivity


class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Main.setOnClickListener{
            startActivity(Intent(this, AllProductsActivity::class.java))
        }

        binding.Fav.setOnClickListener{
            startActivity(Intent(this, FavActivity::class.java))
        }
        binding.button3.setOnClickListener{
            finish();
        }






    }
}