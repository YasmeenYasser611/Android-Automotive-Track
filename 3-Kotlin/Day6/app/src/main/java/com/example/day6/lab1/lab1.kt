package com.example.day6.lab1

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main()
{
    runBlocking()
    {
        launch{
            repeat(10)
            {
                println("$it")
                delay(100)
            }

        }

        async {
            repeat(10)
            {
                println("$it")
                delay(100)
            }
        }

    }

}