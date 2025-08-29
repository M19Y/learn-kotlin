package com.m19y.learn

import org.junit.jupiter.api.Test
import kotlin.collections.filter
import kotlin.collections.map
import kotlin.collections.take

class SequenceTest {

    private val words: List<String> = "The quick brown fox jumps over the lazy dogs".split(" ")

    @Test
    fun notSequenceTest() {
        // each operation will return new list (eager)
        val result: List<String> = words
            .filter {
                println("filter $it")
                it.length > 3
            }.map {
                println("map $it")
                it.uppercase()
            }.take(4)

        println("\nNot Sequence result")
        println(result)
    }

    @Test
    fun sequenceTest() {
        val sequence: Sequence<String> = words.asSequence()

        // sequence will executed by condition (lazy)
        val result: Sequence<String> = sequence
            .filter {
                println("filter $it")
                it.length > 3
            }.map {
                println("map $it")
                it.uppercase()
            }.take(4)

        println("\nSequence result")
        println(result.toList())
    }
}