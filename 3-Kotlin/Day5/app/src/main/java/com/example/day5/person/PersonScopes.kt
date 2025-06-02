package com.example.day5.person

data class PersonScopes(var name: String, var id: Int, var gender: String)

fun main()
{
    var person: PersonScopes? = PersonScopes("Yasmeen", 1234, "Female")

    /************ apply ************/
    // Null-safe with ?.apply
    // Receiver: this
    // Returns: the object itself
    // Use Case: configuring or initializing an object
    person?.apply {
        name = "ApplyName"
        gender = "ApplyGender"
        println("APPLY updated: $this")
    }

    /************ run ************/
    // Null-safe with ?.run
    // Receiver: this
    // Returns: the result of the lambda
    // Use Case: operate on object and return a result
    person?.run {
        name = "RunName"
        id = 9101
        println("RUN updated: $this")
    }

    /************ with ************/
    // Not null-safe by default (must ensure non-null)
    // Receiver: this
    // Returns: the result of the lambda
    // Use Case: group operations on a known non-null object
    with(person!!) {
        name = "WithName"
        gender = "WithGender"
        println("WITH updated: $this")
    }

    /************ let ************/
    // Null-safe with ?.let
    // Receiver: it
    // Returns: the result of the lambda
    // Use Case: null-checking, transformation, scoped access
    person?.let {
        it.name = "LetName"
        it.gender = "LetGender"
        println("LET updated: $it")
    }

    /************ also ************/
    // Null-safe with ?.also
    // Receiver: it
    // Returns: the object itself
    // Use Case: side effects like logging or debugging
    person?.also {
        it.name = "AlsoName"
        it.id = 5678
        println("ALSO updated: $it")
    }

}





