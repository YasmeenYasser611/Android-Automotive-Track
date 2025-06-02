package com.example.calculator

fun main()
{
    var num1 = 0
    var num2 =0
    println("Hello to my calculator !!!!!")
    print("Please Enter The First num if not enter it will be 0 by defult : ")
    var input1 :String? = readLine()
    if(!input1.isNullOrEmpty())
         num1 = input1.toInt()


    print("Please Enter The Second num if not enter it will be 0 by defult: ")
    var input2 :String? = readLine()
    if(!input2.isNullOrEmpty())
        num2 = input2.toInt()

    println("please choose the operation :  ")
    println("0:+ ADD ")
    println("1:- SUB")
    println("2:*  MUL")
    println("3:/  DIV")
    val op :String? = readln()
    when(op)
    {
        "0" -> println(  "Result= $num1 + $num2 = ${num1+num2}" )
        "1" -> println(  "Result= $num1 - $num2 = ${num1-num2}")
        "2" -> println(  "Result= $num1 * $num2= ${num1*num2}")
        "3" -> if(num2 !=0) println(  "Result= $num1 / $num2= ${num1/num2}") else println("Cannot Divide By Zero")
        else -> println(  "Wrong operation")

    }

}