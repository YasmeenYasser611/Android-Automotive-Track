package com.example.day1.model.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.day1.model.remote.Product

@Dao
interface ProductDao {
    @Query("SELECT * FROM Products_Table")
    suspend fun getAllProducts():List<Product>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllProducts(list :List<Product> )
}