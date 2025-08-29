package com.m19y.learn.app

import com.m19y.learn.data.Person

fun main() {
    val person1 = Person();
    person1.firstName = "Bro"
    person1.middleName = "G"
    person1.lastName = "Manhattan"

    person1.sayHello("sis")
    println(person1.getFullName())

    person1.run()
}