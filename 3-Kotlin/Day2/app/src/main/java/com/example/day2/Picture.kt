package com.example.day2

class Picture
{
    fun SumAreas(s1: Shape, s2: Shape, s3: Shape): Double
    {
        return s1.CalcArea() + s2.CalcArea() + s3.CalcArea()
    }
}