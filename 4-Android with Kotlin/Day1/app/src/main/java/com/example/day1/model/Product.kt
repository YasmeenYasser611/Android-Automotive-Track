package com.example.day1.model

import java.io.Serializable

data class Product(var id:Int ,
                   var tittle:String ,
                   var description:String ,
                   var price :Float ,
                   var rating:Float ,
                   var thumbnail:Int):Serializable