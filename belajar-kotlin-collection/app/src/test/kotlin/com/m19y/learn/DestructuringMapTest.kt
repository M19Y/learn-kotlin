package com.m19y.learn

import org.junit.jupiter.api.Test

class DestructuringMapTest {

    @Test
    fun destructureTest() {
        val alphabet = mapOf("A" to "Alfa", "B" to "Bravo", "C" to "Charly")

        for ((key, value) in alphabet){
            println("Key: $key | Value: $value")
        }

        println("\n===========")
        alphabet.forEach { (key, value) -> println("Key: $key | Value: $value") }

        println("\n===========")
        alphabet.forEach { entry -> println("Key: ${entry.component1()} | Value: ${entry.component2()}") }
    }
}