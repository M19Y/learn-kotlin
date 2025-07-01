package com.m19y.learn.app

import com.m19y.learn.data.Gender

fun main() {

    println("Enum properties")
    println(Gender.MALE)
    println(Gender.FEMALE)

    println("\nEnum entries")
    for(gender in Gender.entries){
        println(gender)
    }

    println("\nEnum function")
    println(Gender.MALE.showDesc())
    println(Gender.FEMALE.showDesc())

    println("\nEnum Conversion")
    println(Gender.valueOf("MALE"))
    println(Gender.valueOf("FEMALE"))


}