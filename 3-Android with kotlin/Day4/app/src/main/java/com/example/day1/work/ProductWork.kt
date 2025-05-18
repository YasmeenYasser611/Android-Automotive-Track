package com.example.day1.work

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.example.day1.model.Product
import com.example.day1.model.ProductClient
import com.google.gson.Gson

class ProductWork(context:Context ,workerParameters: WorkerParameters ) :Worker(context , workerParameters)
{
    lateinit var client :ProductClient
    override fun doWork(): Result
    {
        client = ProductClient.instance!!

        var products : List<Product>? = client.makeNetworkCall()

        if (products != null) {
            if(products.isEmpty())
            {
                return Result.failure(workDataOf("Response" to "No Products Found "))

            }
            else
            {
//                return Result.success(workDataOf(Pair("Products" ,products )))
                val json = Gson().toJson(products)
                return Result.success(workDataOf("ProductsJson" to json))


            }


        }
        else
        {
            return Result.failure(workDataOf("Response" to "Products is Null"))
        }
    }

}