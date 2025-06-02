package com.example.day2

abstract class Shape(open var dim: Double)
{
    constructor() : this(0.0)
    abstract fun CalcArea(): Double
}