package com.m19y.learn

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.collections.MutableList

class MutableListTest{
    // mutable means => we can get, update and delete to the list
    private val names: MutableList<String> = mutableListOf("Bro", "Sis", "Unc")

    @Test
    fun addNewItemsTest(){
        assertEquals(3, names.size) // initial size

        // add new items
        names.add("Aunty")
        names.add("Grandpa")
        names.add("Grandma")

        assertEquals(6, names.size) // after add items size

        for (name in names){
            println(name)
        }
    }

    @Test
    fun updateItemsTest() {
        // we can update by using index operator or set function
        names.set(0, "Mail")
        names[1] = "Upin"

        assertEquals("Mail", names[0])
        assertEquals("Upin", names[1])
    }

    @Test
    fun deleteItemsTest() {
        // we can remove an item by using remove function

        val initialSize = 3
        assertEquals(initialSize, names.size)
        assertTrue(names.remove("Bro")) // should return true when item exists
        assertFalse(names.remove("Nothing"))

        // the initial size should greater than the current size of the names items
        assertNotEquals(initialSize, names.size)
        assertTrue(names.size < initialSize)

    }
}

