package com.m19y.learn.operation.retrieve

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class RetrieveByConditionTest {


    @Test
    fun conditionTest() {
        val numbers: List<Int> = (1..20).toList()

        // first
        Assertions.assertEquals(11, numbers.first { it > 10 })
        Assertions.assertThrows<NoSuchElementException>(NoSuchElementException::class.java) {
            numbers.first { it > 20 }
        }

        // first or null
        Assertions.assertEquals(11, numbers.firstOrNull { it > 10 })
        Assertions.assertNull(numbers.firstOrNull { it > 20 })


        // last
        Assertions.assertEquals(9, numbers.last { it < 10 })
        Assertions.assertEquals(20, numbers.last { it > 10 })
        Assertions.assertThrows(NoSuchElementException::class.java) {
            numbers.last { it > 20 }
        }

        // last or null
        Assertions.assertEquals(9, numbers.lastOrNull() { it < 10 })
        Assertions.assertNull(numbers.lastOrNull { it > 20 })

        // find (could be null)
        Assertions.assertEquals(1, numbers.find { it < 10 }) // not 9 (because it find the first element)
        Assertions.assertEquals(11, numbers.find { it > 10 })
        Assertions.assertNull(numbers.find { it > 20 })

    }
}