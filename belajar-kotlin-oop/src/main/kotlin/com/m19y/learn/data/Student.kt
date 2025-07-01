package com.m19y.learn.data

// extension function
class Student(val name: String, val age: Int, private var major: String){
    fun getMajor() = major

    override fun toString(): String = "Student -> ${this.name}"
}

// kita bisa memgakses sumua field kecuali yang visibility-nya private
fun Student.sayHello(name:String) = println("Hello $name, my name is ${this.name} and i'm $age years old")

// error because major is private
//fun Student.sayHi(name:String) = println("Hello $name, my major is ${this.major}")

// check nullable
fun Student?.myAge(): Unit {
    if(this != null){
        println("My age is ${this.age} years old")
    }
}

// extension properties
val Student.upperName: String
    get() = this.name.uppercase()
