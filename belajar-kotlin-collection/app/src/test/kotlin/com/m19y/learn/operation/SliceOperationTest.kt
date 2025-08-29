package com.m19y.learn.operation

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SliceOperationTest {

    private val ints: List<Int> = (0..20).toList()

    @Test
    fun sliceIntegerTest() {
        val afterSliceInt: List<Int> = ints.slice(0..10) // 0 until 10
        Assertions.assertEquals(listOf<Int>(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10), afterSliceInt)
    }

    @Test
    fun sliceWithStep() {
        val afterSliceInt: List<Int> = ints.slice(0..ints.size step 2)

        Assertions.assertEquals((0..20 step 2).toList(), afterSliceInt)
        // dose the same thing
        Assertions.assertEquals(listOf<Int>(0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20), afterSliceInt)

        val downToSlice: List<Int> = ints.slice(20 downTo 0)
        println(downToSlice)

    }
}