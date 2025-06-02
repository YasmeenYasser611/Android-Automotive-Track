package com.example.products.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Products_Table")
data class Product(@PrimaryKey var id:Int ,
                   var title:String ,
                   var description:String ,
                   var price :Double ,
                   var rating:Double ,
                   var thumbnail:String):Serializable