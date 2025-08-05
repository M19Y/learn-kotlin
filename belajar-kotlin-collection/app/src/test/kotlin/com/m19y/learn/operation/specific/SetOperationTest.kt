package com.m19y.learn.operation.specific

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SetOperationTest {

    @Test
    fun specificOperationTest() {
        val firstNum: Set<Int> = (1..10).toSet()
        val secondNum: Set<Int> = (6..15).toSet()

        // combine and eliminate duplicate numbers
        val union: Set<Int> = firstNum union secondNum
        Assertions.assertEquals((1..15).toSet(), union)
        // [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]

        // only get the duplicate in both side of the sets
        val intersect: Set<Int> = firstNum intersect secondNum
        Assertions.assertEquals((6..10).toSet(), intersect)
        // [6,7,8,9,10]

        // will be subtracted divide by the duplicate values
        val subtract1: Set<Int> = firstNum subtract secondNum
        Assertions.assertEquals(setOf<Int>(1,2,3,4,5), subtract1)

        val subtract2: Set<Int> = secondNum subtract firstNum
        Assertions.assertEquals(setOf<Int>(11,12, 13, 14, 15), subtract2)

    }

}