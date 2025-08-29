package com.m19y.learn.operation

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.StringBuilder

class StringRepresentationTest {

    private val names: List<String> = listOf("Apon", "Abilal", "Adam", "Jait")

    @Test
    fun joinToStringTest() {

        val nameStr: String = names.joinToString(separator = " ", prefix = "<", postfix = ">")
        Assertions.assertEquals("<Apon Abilal Adam Jait>", nameStr)

    }

    @Test
    fun joinToStringWithTransformationTest() {
        val nameStr: String = names.joinToString(
            separator = " ",
            prefix = "<",
            postfix = ">"
        ) {
            it.uppercase()
        }

        Assertions.assertEquals("<APON ABILAL ADAM JAIT>", nameStr)
    }

    @Test
    fun stringBuilderTest() {

        val builder: StringBuilder = StringBuilder()
        names.joinTo(buffer = builder, separator = " ", prefix = "*", postfix = "*")
        names.joinTo(buffer = builder, separator = " ", prefix = "?", postfix = "?")
        names.joinTo(buffer = builder, separator = " ", prefix = ">", postfix = "<")

        val appendableString: String = builder.toString()
        Assertions.assertEquals(
            "*Apon Abilal Adam Jait*?Apon Abilal Adam Jait?>Apon Abilal Adam Jait<",
            appendableString
        )
    }

    @Test
    fun numberJoinTest() {
        val numbers: IntRange = 1..10
        val string: String = numbers.joinToString()
        Assertions.assertEquals("1, 2, 3, 4, 5, 6, 7, 8, 9, 10", string)
    }
}