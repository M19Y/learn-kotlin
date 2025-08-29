package com.m19y.learn

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class MutableMapTest {

    private val alphabet: MutableMap<String, String> = mutableMapOf(
        Pair("a", "Alfa"),
        "b" to "Bravo",
        "c" to "Carly", // will be replace by a new item that has the same key
        "c" to "Chamber",
    )

    @Test
    fun getItemsTest() {
        Assertions.assertEquals("Alfa", alphabet["a"])
        Assertions.assertEquals("Bravo", alphabet.get("b"))
        Assertions.assertNull(alphabet.get("z"))
        Assertions.assertEquals("Tango", alphabet.getOrDefault("t", "Tango"))
    }

    @Test
    fun addNewItemsTest() {
        Assertions.assertEquals(3, alphabet.size)

        // we have 2 different way to add a new items to the map
        alphabet.put("d", "Delta")
        alphabet["e"] = "Echo"

        Assertions.assertEquals(4, alphabet.size)
    }

    @Test
    fun updateAnItemTest() {
        Assertions.assertEquals("Alfa", alphabet.get("a"))
        alphabet["a"] = "Animal" // update
        // alphabet.put("a", "Actually")
        Assertions.assertEquals("Animal", alphabet.get("a"))
    }

    @Test
    fun removeAnItemTest() {

        for ((key, value) in alphabet){
            println("$key $value")
        }
        alphabet.remove("c")

        Assertions.assertNull(alphabet.get("c"))
    }
}