package com.example.day6.lab3

import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

fun main()
{
    runBlocking {
        try {
            withTimeout(10000)
            {
                launch{
                    repeat(100)
                    {
                        println("$it")
                        delay(100)
                    }

                }

                async {
                    repeat(1000)
                    {
                        println("$it")
                        delay(100)
                    }
                }
            }



        }
        catch (e: TimeoutCancellationException)
        {
            println(e)
        }
    }
}