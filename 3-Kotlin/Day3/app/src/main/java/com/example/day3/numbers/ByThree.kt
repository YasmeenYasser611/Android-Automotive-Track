package com.example.day3.numbers

class ByThree : NumberSeries {
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
        print("From ByThree ")
        current+=3
        return current
    }
}