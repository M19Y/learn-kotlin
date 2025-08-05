package com.m19y.learn.operation

import org.junit.jupiter.api.Test

class ForEachOperationTest {

    private val alphabet = listOf<String>("A", "B", "C", "D")

    @Test
    fun forEachAndForEachIndexedTest() {

        println("Normal for loop")
        for (name in alphabet) {
            println(name)
        }

        println("\nWith For Each")
        alphabet.forEach { println(it) }

        println("\nWith For Each Indexed")
        alphabet.forEachIndexed { index, name -> println("$name at index -> $index") }
    }
}