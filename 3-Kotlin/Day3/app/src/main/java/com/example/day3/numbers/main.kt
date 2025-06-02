package com.example.day3.numbers

fun main()
{
    val byTwos = ByTwo()
    val byThree = ByThree()
    var ref: NumberSeries
    repeat(5)
    {
        ref = byTwos
        println("By Two : ${ref.getNext()}")
        ref = byThree
        println("By Three : ${ref.getNext()}")

    }

}