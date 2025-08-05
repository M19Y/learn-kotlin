package com.m19y.learn

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ListTest{

    private val names: List<String> = listOf<String>("Apon", "Abilal", "Adam", "Jait")

    @Test
    fun getItemsByIndexTest() {
        assertEquals("Apon", names.get(0)) // get operator
        assertEquals("Apon", names[0]) // index operator
    }

    @Test
    fun getIndexByTheirValuesTest() {
        assertEquals(2, names.indexOf("Adam"))
        assertEquals(3, names.indexOf("Jait"))
        assertEquals(-1, names.indexOf("Bro")) // if it's not found should return -1
    }

    @Test
    fun checkIfItemExists() {
        assertTrue(names.contains("Abilal"))
        assertFalse(names.contains("Sis"))
        assertFalse(names.containsAll(listOf("Abilal", "Bro")))
        assertTrue(names.containsAll(listOf("Abilal", "Jait")))
    }

    @Test
    fun checkIfItemsAreEmpty() {
        assertFalse(names.isEmpty())
        assertTrue(names.isNotEmpty())
    }
}