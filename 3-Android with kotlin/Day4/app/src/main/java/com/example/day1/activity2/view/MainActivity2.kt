package com.example.day1.activity2.view

import android.content.res.Configuration.ORIENTATION_PORTRAIT
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.day1.R
import com.example.day1.activity1.view.ProductListFragment
import com.example.day1.model.Product

class MainActivity2 : AppCompatActivity() {
    private lateinit var dynamicFragment: Fragment2
    private lateinit var fragmentMngr : FragmentManager
    private lateinit var fragmentTransaction: FragmentTransaction

    //@RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        dynamicFragment = Fragment2()
        fragmentMngr = supportFragmentManager
        fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.FragmentContainer , dynamicFragment , "activity2")
        fragmentTransaction.commit()



    }

    override fun onStart() {
        super.onStart()


        if( resources.configuration.orientation== ORIENTATION_PORTRAIT) {
            val Comming = intent
            val product = Comming.getSerializableExtra("product") as Product
            if (product != null) {
                dynamicFragment.ShowProduct(product)
            }

        }
        else
        {
            finish()
        }
    }
}