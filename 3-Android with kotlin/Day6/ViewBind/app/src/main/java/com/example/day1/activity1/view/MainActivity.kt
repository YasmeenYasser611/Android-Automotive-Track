package com.example.day1.activity1.view

import android.content.Intent
import android.content.res.Configuration.ORIENTATION_PORTRAIT
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.day1.R
import com.example.day1.activity2.view.Fragment2
import com.example.day1.activity2.view.MainActivity2
import com.example.day1.model.remote.Product
//import com.example.day1.work.ProductWork

class MainActivity : AppCompatActivity() , Communicator
{
    private lateinit var dynamicFragment: ProductListFragment
    private lateinit var fragmentMngr :FragmentManager
    private lateinit var fragmentTransaction:FragmentTransaction

    private var dynamicFragment2: Fragment2? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)



        dynamicFragment = ProductListFragment()
        fragmentMngr = supportFragmentManager
        fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.staticFragmentContainer , dynamicFragment , "activity1")
        fragmentTransaction.commit()

    }

    override fun ShowProductDetails(it: Product)
    {
        if( resources.configuration.orientation== ORIENTATION_PORTRAIT)
        {

            val intent = Intent(this , MainActivity2::class.java)
            intent.putExtra("product" , it)
            startActivity(intent)
        }
        else
        {
            if (dynamicFragment2 == null)
            {
                dynamicFragment2= Fragment2()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.FragmentContainer, dynamicFragment2!!, "fragment2")
                    .commit()
                supportFragmentManager.executePendingTransactions()

            }
            dynamicFragment2?.ShowProduct(it)

        }
    }
}