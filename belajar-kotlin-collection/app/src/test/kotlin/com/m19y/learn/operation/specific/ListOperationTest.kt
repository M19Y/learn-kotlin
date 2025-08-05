package com.m19y.learn.operation.specific

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ListOperationTest {

    @Test
    fun specificOperationTest() {

        val alphabet: List<String> = listOf("A", "B", "C", "D", "E", "F")

        Assertions.assertEquals("C", alphabet.getOrNull(2))
        Assertions.assertNull(alphabet.getOrNull(10))
        Assertions.assertEquals(listOf<String>("B", "C", "D"), alphabet.subList(1, 4))
        Assertions.assertEquals("Nothing", alphabet.getOrElse(10) {"Nothing"})
    }

    @Test
    fun binarySearchTest() {
        val numbers: List<Int> = listOf(9, 3, 6, 7, 5, 10, 20, 33, 2, 4)
        val sortedNumbers: List<Int> = numbers.sorted()

        Assertions.assertEquals(7,sortedNumbers.binarySearch(10))
    }

    @Test
    fun indexOfTest() {
        val doubledAlphabet: List<String> = listOf("A", "A", "B", "D", "B", "C", "C", "D", "D")

        Assertions.assertEquals(2, doubledAlphabet.indexOf("B"))
        Assertions.assertEquals(4, doubledAlphabet.lastIndexOf("B"))

        Assertions.assertEquals(3, doubledAlphabet.indexOfFirst { it > "C" }) // D // yang paling awal
        Assertions.assertEquals(8, doubledAlphabet.indexOfLast { it > "B" }) // D // yang panling belakang
    }
}