package com.example.day5.library
class Magazine(title: String, ISBN: Int, publication: String, numberOfPages: Int) : LibraryItem(title, ISBN, publication, numberOfPages)
{


    override fun isAvailable(): Boolean
    {
        return !isCheckedOut
    }
}