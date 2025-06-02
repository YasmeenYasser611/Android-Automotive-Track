package com.example.day5.hof;

typealias Operation = (Int, Int) -> Int

val add: Operation = { num1, num2 -> num1 + num2 }
val sub: Operation = { num1, num2 -> num1 - num2 }
val mul: Operation = { num1, num2 -> num1 * num2 }
val div: Operation = { num1, num2 -> if (num2 == 0) 0 else num1 / num2 }

fun calc(num1: Int, num2: Int, op: Operation): Int
{
    return op(num1, num2)
}

fun main()
{
    println("Add: " + calc(1, 2, add))
    println("Sub: " + calc(5, 3, sub))
    println("Mul: " + calc(4, 2, mul))
    println("Div: " + calc(10, 0, div))
}

