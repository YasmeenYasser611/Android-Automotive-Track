package com.example.day5.library

class LibraryDatabase<T : LibraryItem>(var currentLibrarian: Librarian, val availableItems: MutableList<T>, val borrowedItems: MutableMap<T, Person>)
{
    fun addItem(item: T)
    {
        availableItems.add(item)
    }

    fun borrowItem(item: T, person: Person): Boolean
    {
        return if (availableItems.contains(item) && item.isAvailable())
        {
            availableItems.remove(item)
            borrowedItems[item] = person
            item.isCheckedOut = true
            true
        } else {
            false
        }
    }

    fun returnItem(item: T): Boolean {
        return if (borrowedItems.containsKey(item)) {
            borrowedItems.remove(item)

            item.isCheckedOut = false
            availableItems.add(item)
            true
        } else {
            false
        }
    }

    fun viewAvailableItems()
    {
        if (availableItems.isEmpty()) {
            println("No items available.")
        } else {
            println("Available Items:")
            availableItems.forEach { println("- ${it.title} (ISBN: ${it.ISBN})") }
        }
    }

    fun searchForItem(title: String): List<T>
    {
        val match = availableItems.filter { it.title.contains(title) }
        if (match.isEmpty())
        {
            println("No items found with title: $title")
        }
        else
        {
            println("Items found with title $title:")
        }
        return match
    }
}

