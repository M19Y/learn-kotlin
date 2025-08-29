package com.m19y.learn.operation

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class MappingOperationTest {

    @Nested
    inner class MappingForCollection {
        private val names = arrayOf<String>("Abilal", "Apon", "Jait", "Adam", "Patih")

        @Test
        fun manualTransformTest() {
            val mutableList: MutableList<String> = mutableListOf()

            for (name in names) {
                mutableList.add(name.uppercase())
            }

            println(mutableList)
        }

        @Test
        fun transformUsingMapTest() {
            val upperNames: List<String> = names.map { name -> name.uppercase() }.toList<String>()
            println("Mapping list to uppercase")
            println(upperNames)

            val lowerNames: Set<String> = names.map { name -> name.lowercase() }.toSet<String>()
            println("\nMapping set to lowercase")
            println(lowerNames)

            println("\nMapping mutable list to name with index odd")
            val namesOdd: MutableList<String> =
                names.mapIndexedNotNull { index, name -> if (index % 2 == 0) name else null }
                    .toMutableList<String>()
            println(namesOdd)
        }
    }

    @Nested
    inner class MappingForMap {
        private val identity: Map<Int, String> = mapOf(
            1 to "Bro",
            2 to "Sis",
            3 to "Aunty",
            4 to "Unc",
        )

        // we can't change both of them together in one mapping operation.
        // we should change them one by one using key or values from entries

        @Test
        fun transformByKeyOrValueTest() {
            val updatedKey = identity.mapKeys { it.key * 10 }
            val updatedValue = identity.mapValues { it.value.uppercase()}

            println(updatedKey)
            println(updatedValue)
        }

    }

}