package com.example.day5.library

open class Person(val name:String , val id:Int )

data class Librarian(val Libname:String , val Libid:Int , val password:String ):Person(Libname , Libid)

data class User(val username:String , val userid:Int , val jop:String ):Person(username , userid)