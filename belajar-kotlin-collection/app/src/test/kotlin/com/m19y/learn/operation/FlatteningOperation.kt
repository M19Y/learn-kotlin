package com.m19y.learn.operation

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

private class Member(val name: String, val hobbies: List<String>)

class FlatteningOperation {

    @Test
    fun flatteningInnerListTest() {

        val listOfNameList: List<List<String>> = listOf(
            listOf("Apon", "Abilal", "Jait", "Adam", "Patih"),
            listOf("Siti", "Iki", "Gista", "Zara")
        )

        println("nested list")
        println(listOfNameList)

        println("\nflatten list")
        println(listOfNameList.flatten())
    }

    @Test
    fun flatteningUseFlatMap() {

        val members: List<Member> = listOf(
            Member(name = "A", hobbies = listOf("Music", "Play Video Games")),
            Member(name = "B", hobbies = listOf("Play Guitar", "Running")),
            Member(name = "C", hobbies = listOf("Music", "Football")),
        )

        // normal ways
        println("normal ways")
        val listOfHobbiesList:List<List<String>> = members.map { it.hobbies }
        val hobbies: List<String> = listOfHobbiesList.flatten()
        println(hobbies)

        println("\nwith flatmap")
        val hobbiesFlatMap: List<String> = members.flatMap { it.hobbies }
        println(hobbiesFlatMap)

        assertEquals(hobbies, hobbiesFlatMap)


    }
}