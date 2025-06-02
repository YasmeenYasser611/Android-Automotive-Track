package com.example.day6.lab2

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

suspend fun Fact(times:Int=4):Int{
    var counter =1
    repeat(times)
    {
        delay(100)
        counter*=(it +1)
    }
    return counter
}
fun main()
{
    runBlocking {
        val a = async {
            Fact(5)
        }
        println(a.await())
    }

}