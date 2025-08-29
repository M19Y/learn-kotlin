package com.m19y.learn.operation

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class GroupOperationTest {

    @Test
    fun testGroup() {
        val list: List<String> = listOf("a", "b", "a", "a", "c", "c", "b", "aa", "cc", "bb", "abc", "abc")
        val groupList1: Map<String, List<String>> = list.groupBy { data -> data } // grouping by value

        Assertions.assertEquals(
            mapOf<String, List<String>>(
                "a" to listOf("a", "a", "a"),
                "b" to listOf("b", "b"),
                "c" to listOf("c", "c"),
                "aa" to listOf("aa"),
                "cc" to listOf("cc"),
                "bb" to listOf("bb"),
                "abc" to listOf("abc", "abc")
            ), groupList1
        )

        val groupList2: Map<Int, List<String>> = list.groupBy { it.length } // grouping how many character

        Assertions.assertEquals(
            mapOf<Int, List<String>>(
                1 to listOf("a", "b", "a", "a", "c", "c", "b"),
                2 to listOf("aa", "cc", "bb"),
                3 to listOf("abc", "abc")
            ), groupList2
        )


    }
}