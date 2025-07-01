package com.m19y.learn.app

import com.m19y.learn.data.Person

fun main() {
    val person = Person()
    person.firstName = "Bro"
    person.lastName = "G"

    println(person.firstName)
    println(person.lastName)
}