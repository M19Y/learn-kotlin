package com.m19y.learn

import org.junit.jupiter.api.Test

class IterableTest {

    fun <T> printIterable(iterable: Iterable<T>){
        val iterator: Iterator<T> = iterable.iterator()
        while(iterator.hasNext()) println(iterator.next())
    }

    @Test
    fun createTest() {

        printIterable<String>(listOf<String>("A", "I", "U", "E", "0"))
    }
}