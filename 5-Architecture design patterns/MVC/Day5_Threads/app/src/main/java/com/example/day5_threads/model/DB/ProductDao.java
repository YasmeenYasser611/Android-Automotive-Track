package com.example.day5_threads.model.DB;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.day5_threads.model.Pojo.Product;

import java.util.List;

@Dao
public interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void insertItem(Product product);

    @Delete
    public void deleteItem(Product product);

    @Query("Select * from Product")
    public LiveData<List<Product>> getAllItems();
}
