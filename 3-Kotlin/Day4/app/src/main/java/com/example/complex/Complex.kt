package com.example.complex

data class Complex( var real : Double =5.2 , var img :Double=1.2)
{
    constructor(): this(real = 0.0  , img = 0.0)
    operator fun minus(complex :Complex) :Complex
    {
        return Complex(this.real - complex.real , this.img - complex.img)
    }
}

infix operator fun Complex.plus(complex :Complex) :Complex
{
    return Complex(this.real + complex.real , this.img + complex.img)
}

fun Complex.printComplex()
{
    val result = when {
        this.real == 0.0 && this.img == 0.0 -> "0"
        this.real == 0.0 -> "${this.img}i"
        this.img == 0.0 -> "${this.real}"
        this.img > 0 -> "${this.real} + ${this.img}i"
        else -> "${this.real} - ${-this.img}i"
    }
    println(result)
}

fun main()
{
    val c1 :Complex = Complex(img = 2.5 , real = 1.5)
    println(c1)
    val c2 :Complex= Complex(img = 5.2)
    println(c2)
    val c3 :Complex= Complex(real = 1.3)
    println(c3)
    val c4 :Complex=Complex()
    println(c4)

    var sum :Complex = c1 + c2
    sum.printComplex()

    var diff:Complex  = c1 - c3
    diff.printComplex()
}