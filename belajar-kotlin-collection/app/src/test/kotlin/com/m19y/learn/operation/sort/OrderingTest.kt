package com.m19y.learn.operation.sort

import com.m19y.learn.data.Product
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class OrderingTest {

    private val disorderedNumbers: List<Int> = listOf(1, 9, 3, 7, 8, 2, 6, 5, 10, 4)

    @Nested
    inner class BasicOrder {

        @Test
        fun orderByAscAndDescTest() {

            val ascOrder: List<Int> = disorderedNumbers.sorted()
            Assertions.assertEquals(listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), ascOrder)

            val descOrder: List<Int> = disorderedNumbers.sortedDescending()
            Assertions.assertEquals(listOf<Int>(10, 9, 8, 7, 6, 5, 4, 3, 2, 1), descOrder)
        }
    }

    @Nested
    inner class CustomOrder {

        private val products: List<Product> = listOf(
            Product("Comb", 2, 11_000.0),
            Product("Tooth Brush", 5, 5_000.0),
            Product("Mirror", 3, 2_000.0),
        )

        @Test
        fun customOrderTest() {

            val orderByQuantityAsc: List<String> = products.sortedBy { it.quantity }.map { it.name }
            Assertions.assertEquals(
                listOf<String>("Comb", "Mirror", "Tooth Brush"),
                orderByQuantityAsc
            )

            val orderByPriceDesc: List<String> = products.sortedByDescending { it.price }.map { it.name }
            Assertions.assertEquals(
                listOf<String>("Comb", "Tooth Brush", "Mirror"),
                orderByPriceDesc
            )

//            val customComparable: List<Product> = products.sortedWith(compareBy { it.name })
            val customComparable: List<String> = products.sortedWith(Comparator { product1, product2 ->
                product1.quantity.compareTo(product2.quantity)
            }).map { it.name }

            Assertions.assertEquals(
                listOf<String>("Comb", "Mirror", "Tooth Brush"),
                customComparable
            )


        }
    }

    @Nested
    inner class ReverseOrder {
        private val names: MutableList<String> = mutableListOf("Bro", "Sis", "Aunty", "Uncle")

        @Test
        fun reverseTest() {
            val reversedNames: List<String> = names.reversed()  // tidak berubah sama sekali, cuman di reverse
            val referenceReversedNames: MutableList<String> =
                names.asReversed() // akan ikut berubah jika (names) di update

            names.add("Grandpa")

            Assertions.assertEquals(listOf<String>("Uncle", "Aunty", "Sis", "Bro"), reversedNames)
            Assertions.assertEquals(listOf<String>("Grandpa", "Uncle", "Aunty", "Sis", "Bro"), referenceReversedNames)
            Assertions.assertEquals(listOf<String>("Bro", "Sis", "Aunty", "Uncle", "Grandpa"), names)
        }
    }

    @Nested
    inner class RandomOrder{
        @Test
        fun makeListRandomTest() {
            val alphabet:List<Char> = ('a' .. 'm').toList()

            println(alphabet.shuffled())
            println(alphabet.shuffled())
            println(alphabet.shuffled())
            println(alphabet.shuffled())
            println(alphabet.shuffled())

        }
    }

}