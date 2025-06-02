package com.example.day3.numbers

class ByTwo: NumberSeries {
    override var current: Int =0
    override var start: Int =0
        set(value) {
            current = value
            field =value
        }

    override fun reset() {
        current=start
    }

    override fun getNext():Int
    {
        print("From ByTwo ")
        current+=2
        return current
    }

}