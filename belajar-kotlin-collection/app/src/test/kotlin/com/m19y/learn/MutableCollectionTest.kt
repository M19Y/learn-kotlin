package com.m19y.learn

import org.junit.jupiter.api.Test

class MutableCollectionTest {

    fun <T> displayMutableCollection(collection: MutableCollection<T>){
        for (data in collection) {
            println(data)
        }
        print("\n")
    }

    @Test
    fun create() {
        // displayMutableCollection(listOf<String>("A", "B", "C")) // Error (cause list is not child from MutableCollection
        displayMutableCollection<String>(mutableListOf("A", "B", "C"))
        displayMutableCollection<String>(mutableSetOf<String>())
        displayMutableCollection<String>(mutableSetOf())
//        displayMutableCollection(mutableSetOf()) // ERROR (cause kotlin don't know what the type of inference
    }
}