package com.m19y.learn

import org.junit.jupiter.api.Test

class MutableIterableTest {

    fun <T> printIterable(iterable: MutableIterable<T>) {
        val iterator: Iterator<T> = iterable.iterator()
        while (iterator.hasNext()) println(iterator.next())
    }

    @Test
    fun createTest() {

        printIterable<String>(mutableListOf<String>("A", "I", "U", "E", "0"))

        val mutableIterable: MutableIterable<Int> = mutableListOf(9, 8, 7, 3, 2, 1)
        val mutableIterator: MutableIterator<Int> = mutableIterable.iterator()
        while (mutableIterator.hasNext()) {
            val data = mutableIterator.next();
            when {
                data % 2 == 0 -> println(data)
                else -> mutableIterator.remove()
            }
        }

        println(mutableIterable)
    }
}