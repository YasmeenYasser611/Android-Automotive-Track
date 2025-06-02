package com.example.day3.classer
data class Person(var name: String, var address: Address)
data class Address(var streetName: String, var city: String, var building: Building)
enum class Building
{
    VILLA,
    APARTMENT
}
fun main()
{
    var address = Address("Cairo", "Marg", Building.APARTMENT)
    println(address)
    var person = Person("Yasmeen", address)
    println(person)
}