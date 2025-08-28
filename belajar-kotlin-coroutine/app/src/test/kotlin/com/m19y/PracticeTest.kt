package com.m19y

import org.junit.jupiter.api.Test

class PracticeTest {

    @Test
    fun simpleCollections() {

        val names: List<String> = listOf("Bro", "Sis", "Unc")

        names.forEach { println(it) }
    }
}