package com.m19y.learn.operation

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class FilteringOperationTest {

    private val names: List<String> = listOf("Apon", "Abilal", "Adam", "Jait", "Patih")

    @Test
    fun filterTest() {
        // find names where it has less than 5 character
        val people: List<String> = names.filter { it.length < 5 }

        Assertions.assertEquals(3, people.size)
        Assertions.assertEquals(listOf<String>("Apon", "Adam", "Jait"), people)
    }

    @Test
    fun filterIndexedTest() {
        // get only the odd index from names
        val people: List<String> = names.filterIndexed { index, name -> index % 2 == 0 }
        Assertions.assertEquals(3, people.size)
        Assertions.assertEquals(listOf<String>("Apon", "Adam", "Patih"), people)
    }

    @Test
    fun filterInstanceTest() {
        val randomBucket: List<Any?> = listOf(null, "Apon", 5, 4, null, "Red", 1, 2, 3, "Grape")

        // get only String
        val stringOnly: List<String> = randomBucket.filterIsInstance<String>()
        Assertions.assertEquals(listOf<String>("Apon", "Red", "Grape"), stringOnly)

        // get only Integer
        val intOnly: List<Int> = randomBucket.filterIsInstance<Int>()
        Assertions.assertEquals(listOf<Int>(5, 4, 1, 2, 3), intOnly)

        // don't get the null values
        val notNullValues: List<Any> = randomBucket.filterNotNull<Any>()
        Assertions.assertEquals(listOf<Any>("Apon", 5, 4, "Red", 1, 2, 3, "Grape"), notNullValues)

    }
}