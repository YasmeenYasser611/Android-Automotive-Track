package com.example.day3.numbers

interface NumberSeries {
    var start:Int
    var current:Int
    fun reset()
    fun getNext():Int
}