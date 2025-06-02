package com.example.day5.library

class Book(title: String, ISBN: Int, publication: String, numberOfPages: Int) : LibraryItem(title, ISBN, publication, numberOfPages)
{


    override fun isAvailable(): Boolean
    {
        return !isCheckedOut
    }
}
