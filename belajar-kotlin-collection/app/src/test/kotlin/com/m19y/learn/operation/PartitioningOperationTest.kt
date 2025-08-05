package com.m19y.learn.operation

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class PartitioningOperationTest {

    private val names: List<String> = listOf("Apon", "Abilal", "Adam", "Jait")

    @Test
    fun partitionTest() {
        // divide 2 different collection using partitioning
        // -> first param should be the filtered
        // -> second param should be the rest

        // find names that has less than 5 character and place it to the first param
        // and the rest in the second param
        val partition: Pair<List<String>, List<String>> = names.partition { it.length < 5 }
        val (match, notMatch) = names.partition { it.length < 5 } // destructuring
        println("Match ================")
        println(match)
        println("\nNot Match ================")
        println(notMatch)

        Assertions.assertEquals(3, partition.first.size)
        Assertions.assertEquals(listOf<String>("Apon", "Adam", "Jait"), partition.first)

        Assertions.assertEquals(1, partition.second.size)
        Assertions.assertEquals(listOf<String>("Abilal"), partition.second)


    }
}