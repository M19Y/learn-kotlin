package com.m19y.learn.operation

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class TakeAndDropOperationTest {

    private val alphabet: List<Char> = ('a'..'z').toList()


    @Test
    fun takeTest() {
        val takeFirst3Chars = alphabet.take(3)
        Assertions.assertEquals(listOf<Char>('a', 'b', 'c'), takeFirst3Chars)

        val takeWhileCharIsGreaterThanF = alphabet.takeWhile { it < 'f' }
        Assertions.assertEquals(listOf<Char>('a', 'b', 'c', 'd', 'e'), takeWhileCharIsGreaterThanF)

        val takeTheLastOfTwoAlphabet = alphabet.takeLast(2)
        Assertions.assertEquals(listOf<Char>('y', 'z'), takeTheLastOfTwoAlphabet)

        val takeFromTheLastUntilItHitsP = alphabet.takeLastWhile { it > 'p' }
        Assertions.assertEquals(listOf<Char>('q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'), takeFromTheLastUntilItHitsP)
    }

    @Test
    fun dropTest() {
        val dropAllFirst23Char = alphabet.drop(23)
        Assertions.assertEquals(listOf<Char>('x', 'y', 'z'), dropAllFirst23Char)

        val dropAllLast23Char = alphabet.dropLast(23)
        Assertions.assertEquals(listOf<Char>('a', 'b', 'c'), dropAllLast23Char)

        val dropWhileCharIsSmallerThanQ = alphabet.dropWhile { it < 'q' }
        Assertions.assertEquals(listOf<Char>('q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'), dropWhileCharIsSmallerThanQ)

        val dropFromLastWhileCharIsGreaterThanF = alphabet.dropLastWhile { it > 'f' }
        Assertions.assertEquals(listOf<Char>('a', 'b', 'c', 'd', 'e', 'f'), dropFromLastWhileCharIsGreaterThanF)
    }

}