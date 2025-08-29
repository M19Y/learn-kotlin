package com.m19y

import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.TestMethodOrder


// defaultnya adalah MethodName
// Random
// MethodName
@TestMethodOrder(value = MethodOrderer.MethodName::class)
class OrderedTest {

    @Test
    @Order(2)
    fun testA() {
    }

    @Test
    @Order(3)
    fun testB() {
    }

    @Test
    @Order(1)
    fun testC() {
    }
}