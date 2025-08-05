package com.m19y.learn.operation

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class TestOperationTest {

    private val names: List<String> = listOf("Apon", "Abilal", "Adam", "Jait")

    @Test
    fun conditionalOperationTest() {
        // check if names has any data inside it
        Assertions.assertTrue(names.any()) // yes, indeed

        // check if names doesn't have any data inside it
        Assertions.assertFalse(names.none()) // false, because it has

        // check if the names has any data that length greater than 5
        Assertions.assertTrue(names.any { it.length > 5 })

        // check if names doesn't have any data that length greater than 5
        Assertions.assertFalse(names.none { it.length > 5 }) // false, because it has

        // check if all the name has length more that 5
        Assertions.assertFalse { names.all { it.length > 5 } } // false because there is some name has less than 5 length
    }
}