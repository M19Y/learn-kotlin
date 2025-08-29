package com.m19y.learn

import com.m19y.learn.data.Color
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SetTest {

    // set will store only unique items,
    // using equals and hashcode comparison

    private val colors: Set<Color> = setOf(
        Color("Red"),
        Color("Green"),
        Color("Blue"),
        Color("Purple"),
        Color("Green"), // duplicate
        Color("Red"), // duplicate
        Color("Blue"), // duplicate
    )

    @Test
    fun setTest() {

        assertEquals(4, colors.size) // the size must be 4
        assertTrue(colors.contains(Color("Red")))
        assertFalse(colors.contains(Color("Orange")))

        for (color in colors) {
            println(color)
        }
    }
}