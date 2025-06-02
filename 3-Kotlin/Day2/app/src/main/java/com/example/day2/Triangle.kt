package com.example.day2

class Triangle : Shape {

    var height: Double = 0.0

    constructor() : super(0.0)
    {
        height = 0.0
    }

    constructor(base: Double, height: Double) : super(base) {
        this.height = height
    }
    constructor(width: Double) : super(width)
    {
        this.height = width

    }

    override fun CalcArea(): Double {
        return 0.5 * dim * height
    }
}
