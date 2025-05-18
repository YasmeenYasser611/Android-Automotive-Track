package com.example.day1.model

import java.io.Serializable

data class Product(var id:Int ,
                   var title:String ,
                   var description:String ,
                   var price :Double ,
                   var rating:Double ,
                   var thumbnail:String):Serializable