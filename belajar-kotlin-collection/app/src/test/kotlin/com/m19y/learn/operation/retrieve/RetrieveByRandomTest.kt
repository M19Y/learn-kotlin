package com.m19y.learn.operation.retrieve

import org.junit.jupiter.api.Test

class RetrieveByRandomTest {

    @Test
    fun getRandomItemTest() {
        val numbers: List<Int> = (1 .. 100).toList()

        println(numbers.random())
        println(numbers.random())
        println(numbers.random())
        println(numbers.random())
        println(numbers.random())
    }
}