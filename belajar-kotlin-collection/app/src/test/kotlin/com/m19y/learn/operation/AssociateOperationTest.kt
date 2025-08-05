package com.m19y.learn.operation

import org.junit.jupiter.api.Test

class AssociateOperationTest {

    private val names: List<String> = listOf("Apon", "Bilal", "Cece", "David")

    @Test
    fun createAssociateTest() {

        val map1: Map<String, Int> = names.associate { Pair("$it-${it.length}", it.length) }
        val map2: Map<String, Int> = names.associate { Pair(it, it.length) }
        val map3: Map<String, Int> = names.associateWith { it.length } // will set a value for that names
        val map4: Map<Int, String> = names.associateBy { it.length } // will set a key for that names

        println("Change both key and value -> associate")
        println(map1)

        println("\nChange only the value -> associate with")
        println(map3)

        println("\nChange only the key -> associate by")
        println(map4)
    }
}