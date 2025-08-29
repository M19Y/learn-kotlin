package com.m19y.learn

import org.junit.jupiter.api.Test

// Collection ada interface parent dari set dan juga list
class CollectionTest {


    fun <T> displayCollection(collection: Collection<T>) {
        for (data in collection) {
            println(data)
        }
        print("\n")
    }

    @Test
    fun createTest() {
        displayCollection(listOf<String>("Bro", "Sis"))
        displayCollection(setOf<String>("Unc", "Aunty"))
        displayCollection(mapOf<String, String>("A" to "Alfa", "B" to "Bravo").entries)

        val listAsCollection: Collection<String> = mutableListOf<String>("A", "B", "C", "D")
        val setAsCollection: Collection<Int> = mutableSetOf<Int>(9,10,1,2,3)
        displayCollection(listAsCollection)
        displayCollection(setAsCollection)
    }
}