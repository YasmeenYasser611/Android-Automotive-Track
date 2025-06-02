package com.example.day5.library

fun main()
{
    val librarian = Librarian("Sarah", 1, "pass123")

    val book1 = Book("book1", 101, "Yasmen", 300)
    val magazine1 = Magazine("mag1", 202, "Eman", 50)
    val journal1 = Journal("journal1", 303, "Bader", 100)

    val user = User("Yasmeen", 2, "Student")

    val bookDB = LibraryDatabase(librarian, mutableListOf(book1), mutableMapOf())
    val magazineDB = LibraryDatabase(librarian, mutableListOf(magazine1), mutableMapOf())
    val journalDB = LibraryDatabase(librarian, mutableListOf(journal1), mutableMapOf())


    bookDB.viewAvailableItems()
    println(bookDB.borrowItem(book1, user))
    bookDB.viewAvailableItems()
    println(bookDB.returnItem(book1))
    bookDB.viewAvailableItems()
    println(bookDB.searchForItem("book1"))
    bookDB.addItem(Book("book2", 101, "Yasmen", 300))
    bookDB.viewAvailableItems()


    magazineDB.viewAvailableItems()
    println(magazineDB.borrowItem(magazine1, user))
    magazineDB.viewAvailableItems()
    println(magazineDB.returnItem(magazine1))
    magazineDB.viewAvailableItems()
    println(magazineDB.searchForItem("mag1"))
    magazineDB.addItem( Magazine("mag2", 202, "Eman", 50))
    magazineDB.viewAvailableItems()


    journalDB.viewAvailableItems()
    println(journalDB.borrowItem(journal1, user))
    journalDB.viewAvailableItems()
    println(journalDB.returnItem(journal1))
    journalDB.viewAvailableItems()
    println(journalDB.searchForItem("mag1"))
    journalDB.addItem( Journal("journal2", 303, "Bader", 100))
    journalDB.viewAvailableItems()

}
