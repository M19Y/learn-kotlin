package com.m19y.learn.operation

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ChunkedOperationTest {

    @Test
    fun chunkedTest() {
        val list: List<Int> = (1..100).toList()

        val chunkedList: List<List<Int>> = list.chunked(10)

        Assertions.assertEquals(listOf<List<Int>>(
            (1..10).toList(),
            (11..20).toList(),
            (21..30).toList(),
            (31..40).toList(),
            (41..50).toList(),
            (51..60).toList(),
            (61..70).toList(),
            (71..80).toList(),
            (81..90).toList(),
            (91..100).toList(),
        ), chunkedList)
    }

    @Test
    fun chuckedWithTransformationTest() {
        val list: List<Int> = (1 .. 20).toList()

        // using map
        val chunkedList11 = list.chunked(5).map { numbers : List<Int> ->
            var total = 0
            for (num in numbers){
                total += num
            }
            total
        }

        // using chunked transformation
        val chunkedList: List<Int> = list.chunked(5) { item : List<Int> ->
            var total = 0
            for (num in item){
                total += num
            }
            total
        }

        Assertions.assertEquals(
            listOf<Int>(15, 40, 65, 90), chunkedList
        )
    }
}

