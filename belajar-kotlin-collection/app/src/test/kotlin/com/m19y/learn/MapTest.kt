package com.m19y.learn

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
class MapTest {

    @Test
    fun createMapTest() {

        val names : Map<String, String> = mapOf(
            Pair("a", "abilal"),
            "b" to "bibi", // pair
            "c" to "cyber"
        )

        for ((key, value) in names){
            println("$key $value")
        }

        assertEquals(3, names.size)

    }
}