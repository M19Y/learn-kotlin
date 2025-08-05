package com.m19y.learn

import org.junit.jupiter.api.Test

class IteratorTest {

    fun <T> displayListIteratorNextAndPrevious(listIterator: ListIterator<T>) {
        println("Next----")
        while (listIterator.hasNext()) println(listIterator.next())
        println("\nPrevious----")
        while (listIterator.hasPrevious()) println(listIterator.previous())
    }

    @Test
    fun listIteratorTest() {
        val alphabet: ListIterator<String> = listOf<String>("A", "B", "C", "D").listIterator()
        displayListIteratorNextAndPrevious(alphabet)
    }

    @Test
    fun mutableListIteratorTest() {
        val alphabet: MutableListIterator<Int> = mutableListOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).listIterator()

        while (alphabet.hasNext()) {
            val data = alphabet.next()
            if (data % 2 == 0) alphabet.remove()
        }
        displayListIteratorNextAndPrevious(alphabet)
    }
}