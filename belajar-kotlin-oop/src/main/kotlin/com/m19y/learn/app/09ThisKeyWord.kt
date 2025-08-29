package com.m19y.learn.app

import com.m19y.learn.data.Person

fun main() {

    // this key word itu akan melakukan reference pada Object classnya
    // this juga berfungsi untuk menghindari variable shadowing

    val person = Person()
    person.firstName = "Bro"
    person.middleName = "G"
    person.lastName = "New york"

    person.sayHello("Sis", "Tokyo")
}