package com.m19y.learn.data

// properties
class Person{
    var firstName:String = ""
    var middleName:String? = null
    var lastName:String = ""

    fun sayHello(name:String): Unit {
        println("Hello $name my name is $firstName")
    }

    // overloading function sayHello
    // with this key word
    fun sayHello(firstName:String, lastName:String): Unit {
        println("Hello $firstName $lastName my name is ${this.firstName}")
    }


    // unrecommended
    // fun sayHello(firstNameParam:String, lastNameParam:String): Unit {
    //    println("Hello $firstNameParam $lastNameParam my name is $firstName")
    // }

    fun run(){
        println("Im running")
    }

    fun getFullName() : String{
        return "$firstName $middleName $lastName"
    }
}