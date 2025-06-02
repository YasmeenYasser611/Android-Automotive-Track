package com.example.day1.model.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.products.data.model.Product

@Database(entities = arrayOf(Product::class) , version = 1)
abstract class LocalDatabase: RoomDatabase() {
    abstract fun getProductDao():IProductDao

    companion object{
        @Volatile
        private var INSTANCE:LocalDatabase? = null
        fun getInstance(context:Context):LocalDatabase{
            return INSTANCE ?: synchronized(this){
                val temp=Room.databaseBuilder(context.applicationContext , LocalDatabase::class.java , "Products_Table").build()
                INSTANCE= temp
                temp
            }
        }
    }
}