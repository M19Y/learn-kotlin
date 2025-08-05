package com.m19y.learn

import com.m19y.learn.data.Color
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MutableSetTest {

    private val colors: MutableSet<Color> = mutableSetOf(
        Color("Red"),
        Color("Green"),
        Color("Green"),
        Color("Green"),
        Color("Blue"),
        Color("Blue"),
        Color("Blue"),
    )

    @Test
    fun mutableSetTest() {
        assertEquals(3, colors.size)
        assertTrue(colors.contains(Color("Red")))

        for (color in colors) {
            println(color.name)
        }
    }
}