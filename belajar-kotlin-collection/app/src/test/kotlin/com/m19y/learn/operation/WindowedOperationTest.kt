package com.m19y.learn.operation

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class WindowedOperationTest {

    @Test
    fun windowedTest() {
        val list: List<Int> = listOf(1, 2, 3, 4, 5)

        val windowed1: List<List<Int>> = list.windowed(size = 3, step = 1, partialWindows = false)

        Assertions.assertEquals(
            listOf<List<Int>>(
                listOf(1, 2, 3),
                listOf(2, 3, 4),
                listOf(3, 4, 5),
            ), windowed1
        )

        val windowed2: List<List<Int>> = list.windowed(size = 3, step = 1, partialWindows = true)

        Assertions.assertEquals(
            listOf<List<Int>>(
                listOf(1, 2, 3),
                listOf(2, 3, 4),
                listOf(3, 4, 5),
                listOf(4, 5),
                listOf(5),
            ), windowed2
        )

        // with transformation
        val windowed3: List<Int> = list.windowed(size = 3, step = 1, partialWindows = true, transform = { it.size })

        Assertions.assertEquals(listOf<Int>(3, 3, 3, 2, 1), windowed3)

        val windowed4: List<Int> = list.windowed(size = 3, step = 1, partialWindows = false, transform = { it.size })

        Assertions.assertEquals(listOf<Int>(3, 3, 3), windowed4)

        // with step 2
        val windowed5: List<List<Int>> = list.windowed(size = 3, step = 2, partialWindows = false)

        Assertions.assertEquals(
            listOf<List<Int>>(
                listOf(1, 2, 3),
                listOf(3, 4, 5),
            ), windowed5
        )

        val windowed6: List<List<Int>> = list.windowed(size = 3, step = 2, partialWindows = true)

        Assertions.assertEquals(
            listOf<List<Int>>(
                listOf(1, 2, 3),
                listOf(3, 4, 5),
                listOf(5),
            ), windowed6
        )

    }
}