package com.m19y.learn.operation

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class ZippingOperationsTest {

    // if the length/size of the lists are different,
    // it will also create a list, that references the shorter length of the list
    // like (red, green, purple) and (Dragon Fruit, Apple)
    // it should be like -> [(red, Dragon Fruit), (green, Apple)]
    // the purple will be ignored (because it hasn't had any pair)
    private val colors: List<String> = listOf("red", "green", "purple")
    private val fruits: List<String> = listOf("Dragon Fruit", "Apple", "Grape")

    @Nested
    inner class Zip {

        @Test
        fun combineCollectionsTest() {

            println("Using method infix zip")
            val colorsOfFruits: List<Pair<String, String>> = colors zip fruits
            println(colorsOfFruits)

            val defaultBehavior: List<Pair<String, String>> =
                colors.zip(fruits) { collection1, collection2 ->
                    collection1 to collection2
                }
            println("\nDefault Behaviour")
            println(defaultBehavior)

            println("\nTransform Two list into one list")
            val combineCollections: List<String> = colors.zip(fruits) { list1, list2 ->
                "$list2 is $list1"
            }
            println(combineCollections)

        }
    }

    @Nested
    inner class Unzip {

        @Test
        fun unzipCollectionTest() {
            // when using unzip, the type of object should be Pair<K,V>
            val colorsOfFruits: List<Pair<String, String>> = colors.zip(fruits)

            println("Zipping ------------>")
            println(colorsOfFruits) // [ (..), (..)]

            println("\nUnzipping ---------->")
            println(colorsOfFruits.unzip()) // ( [..], [..] )

            println("\nAfter unzip")
            val colorList: List<String> = colorsOfFruits.unzip().first
            println(colorList)
            val fruitList: List<String> = colorsOfFruits.unzip().second
            println(fruitList)


            Assertions.assertEquals(colors, colorList)
            Assertions.assertEquals(fruits, fruitList)

        }
    }
}
