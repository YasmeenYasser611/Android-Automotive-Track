package com.example.day2

class Circle: Shape
{
    constructor() : super(0.0)
    {
    }
    constructor(width: Double) : super(width)
    {
    }
    override fun CalcArea(): Double
    {
        return 3.14*dim*dim
    }
}