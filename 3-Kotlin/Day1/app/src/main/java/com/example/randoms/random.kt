package com.example.randoms

import java.util.Random

fun main()
{
    repeat(100)
    {
        var num = Random().nextInt( 100)
        println(if(num <= 10) num else 0)

    }
}