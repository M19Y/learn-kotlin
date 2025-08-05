package com.m19y.learn.operation

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CheckingExistenceTest {

    @Test
    fun checkingTest() {
        val numbers: List<Int> = (1..10).toList()

        Assertions.assertTrue(numbers.contains(2))
        Assertions.assertTrue(numbers.containsAll(listOf(1, 3, 5)))

        Assertions.assertFalse(numbers.contains(11))
        Assertions.assertFalse(numbers.containsAll(listOf(1, 3, 0))) // because all should match

        Assertions.assertTrue(numbers.isNotEmpty()) // because numbers has items
        Assertions.assertFalse(numbers.isEmpty())

    }
}