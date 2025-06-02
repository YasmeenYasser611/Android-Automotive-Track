package com.example.day2
class Rect: Shape
{
    private var height: Double = 0.0
    override var dim :Double = 0.0

    constructor(width: Double, height: Double) : super(width)
    {
        this.height = height
        this.dim=width
    }
    constructor(width: Double) : super(width)
    {
        this.height = width
        this.dim=width
    }
    constructor() : super(0.0)
    {
        this.height = 0.0
    }

    fun setHeight(h: Double) {
        height = h
    }

    fun getHeight(): Double {
        return height
    }

    override fun CalcArea(): Double {
        return dim * height
    }
}