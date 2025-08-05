package com.m19y.learn.operation.specific

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class MapOperationTest {

    private val alphabet: Map<String, String> = mapOf(
        "A" to "Alfa",
        "B" to "Bravo",
        "D" to "Delta",
        "C" to "Charly"
    )

    @Test
    fun getTest() {

        Assertions.assertNull(alphabet.get("Z"))
        Assertions.assertEquals("Alfa", alphabet.get("A"))
        Assertions.assertEquals("Alfa", alphabet.getValue("A"))
        Assertions.assertThrows<NoSuchElementException>(NoSuchElementException::class.java) {
            alphabet.getValue("X")
        }

    }

    @Test
    fun filterTest() {

        // we want to get B and D
        Assertions.assertEquals(
            mapOf("B" to "Bravo", "D" to "Delta"),
            alphabet.filter { it.value.length > 4 && it.value.length < 6 })

        Assertions.assertEquals(
            mapOf("A" to "Alfa", "D" to "Delta", "C" to "Charly"),
            alphabet.filterKeys { it != "B" })

        Assertions.assertEquals(
            mapOf("B" to "Bravo", "D" to "Delta", "C" to "Charly"),
            alphabet.filterValues { it.length > 4 })

    }
}
