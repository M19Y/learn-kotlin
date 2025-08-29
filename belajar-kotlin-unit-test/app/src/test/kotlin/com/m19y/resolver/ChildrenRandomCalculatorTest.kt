package com.m19y.resolver

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import java.util.Random

class ChildrenRandomCalculatorTest : ParentRandomCalculatorTest() {


    @Test
    fun simpleCalculatorTest(random: Random) {

        val first: Int = random.nextInt(10)
        val second: Int = random.nextInt(10)

        val result: Int = calculator.add(first, second)
        val expectation: Int = first + second
        Assertions.assertEquals(expectation, result)
    }

    @DisplayName("Test calculator random")
    @RepeatedTest(10, name = "{displayName} ke {currentRepetition} dari {totalRepetitions}")
    fun calculatorRepeatedTest(random: Random) {

        val first: Int = random.nextInt(10)
        val second: Int = random.nextInt(10)

        val result: Int = calculator.add(first, second)
        val expectation: Int = first + second

        println(result)

        Assertions.assertEquals(expectation, result)
    }
}