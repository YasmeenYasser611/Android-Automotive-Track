package com.example.day2

fun main()
{
    val rect1 = Rect(5.0)
    println(rect1.CalcArea())
    val tri1 = Triangle(4.0 , 5.0)
    println(tri1.CalcArea())
    val circle = Circle(10.0)
    println(circle.CalcArea())
    val p = Picture()
    val totalArea = p.SumAreas(rect1, tri1, circle)
    println(totalArea)

}