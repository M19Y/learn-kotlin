package com.m19y.learn.app

import com.m19y.learn.data.Application
import com.m19y.learn.data.Utilities

fun main() {

    println("Singleton Object")
    println(Utilities.name)
    println(Utilities.bold("Bro"))

    Utilities.name = "Sis"
    a()
    b()

    // inner object (mendeklarasikan di dalam class)
    println("\nInner Object")
    println(Application.Utilities.makeSmall("BRO"))
    println(Application.Utilities.makeSmall("Sis"))

    // companion object
    println("\nCompanion Object")
    Application.Companion.helo("Bro")
    Application.helo("Sis")
}

fun a() = println(Utilities.name)
fun b() = println(Utilities.name)