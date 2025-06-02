package com.example.day6.lab4

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking


suspend fun sum(array:Array<Int>):Int
{
    var sum =0
    repeat(array.size)
    {
        delay(100)
        sum+= array[it]
    }
    return sum
}
fun main()
{
    val arr = arrayOf(1, 2, 3, 5)
    runBlocking {
        val a = async {

            sum(arr)
        }
        println(a.await())
    }

}