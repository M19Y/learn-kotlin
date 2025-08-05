package com.m19y.learn

import org.junit.jupiter.api.Test

class PairTest {

    @Test
    fun createPair() {

        val pair1: Pair<String, String> = Pair("Male", "Bro")
        println(pair1.first)
        println(pair1.second)

        val pair2: Pair<String, String> = "Female" to "Sis"
        println(pair2.first)
        println(pair2.second)
    }
}