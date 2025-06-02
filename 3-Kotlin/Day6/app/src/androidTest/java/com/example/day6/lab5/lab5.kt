package com.example.day6.lab5

import kotlinx.coroutines.async
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.CancellationException

fun main()
{
    runBlocking()
    {
        val job1 = launch {
            repeat(10)
            {
                println("JOb1 $it")
                delay(100)
            }

        }

        job1.join()
        val job2 = async {
            try {
                repeat(10)
                {
                    println("job2 $it")
                    delay(10000)
                }
            }catch (ex: CancellationException){
                println(ex)
            }
        }
        delay(100)
        job2.cancel(CancellationException("Try to cancel"))
//        job2.cancel()

        try {
            val job3 = async {

                repeat(10)
                {
                    println("job3 $it")
                    delay(10000)
                }
            }
            delay(100)
            job3.cancelAndJoin()

        } catch (e: CancellationException) {
            println(e)
        }


    }
}