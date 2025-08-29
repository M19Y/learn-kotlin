package com.m19y.learn.operation

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class PlusMinusOperationTest {

    @Test
    fun listTest() {
        val names: List<String> = listOf("Apon", "Abilal")

        val list1 = names + "Bro" // wll create a new list
        Assertions.assertEquals(listOf<String>("Apon", "Abilal", "Bro"), list1)

        val list2 = list1 + listOf<String>("Besbes")
        Assertions.assertEquals(listOf<String>("Apon", "Abilal", "Bro", "Besbes"), list2)

        val list3 = list2 - "Apon"
        Assertions.assertEquals(listOf<String>("Abilal", "Bro", "Besbes"), list3)

        val list4 = list3 - listOf<String>("Besbes", "Abilal")
        Assertions.assertEquals(listOf<String>("Bro"), list4)
    }

    @Test
    fun mapTest() {
        val alphabet: Map<String, String> = mapOf("A" to "Alfa", "B" to "Bravo", "C" to "Charly")

        val map1 = alphabet - "B"
        Assertions.assertEquals(mapOf<String, String>("A" to "Alfa", "C" to "Charly"), map1)

        val map2 = map1 + Pair<String, String>("D", "Delta")
        Assertions.assertEquals(
            mapOf<String, String>("A" to "Alfa", "C" to "Charly", "D" to "Delta"),
            map2
        )

    }
}