package com.m19y.learn.operation.retrieve

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class RetrieveByPositionTest {

    @Test
    fun getElementsTest() {
        val names: Set<String> = setOf("Abilal", "Apon", "Jait")

        // elements
        Assertions.assertEquals("Abilal", names.elementAt(0))
        Assertions.assertEquals("Jait", names.elementAtOrNull(2))
        Assertions.assertNull(names.elementAtOrNull(3))
        Assertions.assertEquals("Apon", names.elementAtOrElse(1) { it -> "Bro $it" })
        Assertions.assertEquals("Bro 3", names.elementAtOrElse(3) { it -> "Bro $it" })

        // first/last
        Assertions.assertEquals("Abilal", names.first())
        Assertions.assertEquals("Jait", names.last())


    }
}