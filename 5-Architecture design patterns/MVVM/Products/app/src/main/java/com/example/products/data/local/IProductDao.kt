package com.example.day1.model.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.products.data.model.Product

@Dao
interface IProductDao {
    @Query("SELECT * FROM Products_Table")
    suspend fun getAllProducts():List<Product>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllProducts(list :List<Product> )

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(product: Product)

    @Delete
    suspend fun delete(product : Product)
}