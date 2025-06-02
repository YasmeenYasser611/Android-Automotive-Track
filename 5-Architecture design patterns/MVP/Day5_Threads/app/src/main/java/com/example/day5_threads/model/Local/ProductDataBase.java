package com.example.day5_threads.model.Local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.day5_threads.model.Pojo.Product;

@Database(entities = {Product.class}, version = 1)
public abstract class ProductDataBase extends RoomDatabase
{
    public abstract ProductDao getProductDao();
    public static ProductDataBase gatInstance(Context context)
    {
        return Room.databaseBuilder(context, ProductDataBase.class , "Products_db").build();
    }


}
