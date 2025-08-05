package com.m19y.learn

import org.junit.jupiter.api.Test
import java.util.SortedSet

class ConversionsTest {

    @Test
    fun conversionTest() {

        val array: Array<Int> = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val range: IntRange = 1..10

        val list: List<Int> = array.toList()
        val set: Set<Int> = range.toSet()

        val mutableList: MutableList<Int> = range.toMutableList()
        val mutableSet: MutableSet<Int> = array.toMutableSet()

        val listToMutable: MutableList<Int> = list.toMutableList()
        val setToMutable: MutableSet<Int> = set.toMutableSet()

        val unOrderedNumbers = arrayOf(1,9,2,8,3,7,4,6,5)
        val orderedSet: SortedSet<Int> = unOrderedNumbers.toSortedSet()
    }
}