package com.example.hello

fun main()
{
    print("Please Enter Your name: ")
    var str :String? = readln()
    if(str.isNullOrEmpty())
        println("Hello Ghost!! ")
    else
        println("Hello $str :)")

}

