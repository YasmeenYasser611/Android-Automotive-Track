package com.example.day5.library

open abstract class LibraryItem(val title: String, val ISBN: Int, val publication: String, val numberOfPages: Int)
{
    var isCheckedOut: Boolean = false
    abstract fun isAvailable(): Boolean
}