package com.m19y.learn.operation

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class AggregateTest {

    @Test
    fun aggregateTest() {
        val numbers: List<Int> = (1 .. 100).toList()

        Assertions.assertEquals(100, numbers.max())
        Assertions.assertEquals(1, numbers.min())
        Assertions.assertEquals(5050, numbers.sum())
        Assertions.assertEquals(50.5, numbers.average())
        Assertions.assertEquals(2500, numbers.sumOf { it / 2 }) // each element will be divided by 2
    }

    @Test
    fun thisIsHowSumOfWorks() {

        var temp: Int = 0
        for (number in 1 .. 100){
            println("$number / 2 = ${number / 2} ")
            temp += number / 2
        }
        println(temp)
    }
}