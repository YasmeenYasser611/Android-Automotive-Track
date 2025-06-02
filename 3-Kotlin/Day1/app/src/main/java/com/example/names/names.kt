package com.example.names

fun main()
{
    print("Please Enter First name: ")
    val str :String? = readLine()
    if(str.isNullOrEmpty())
        println("Invalid First Name ")
    else
    {
        print("Please Enter Last name: ")
        val str2 :String? = readLine()
        if(str2.isNullOrEmpty())
            println("Invalid Last Name ")
        else
            println("Hello $str $str2")
    }
}