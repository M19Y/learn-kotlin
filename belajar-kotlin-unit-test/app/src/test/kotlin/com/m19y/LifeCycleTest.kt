package com.m19y

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

// by default lifecycle test adalah PER_METHOD
@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
class LifeCycleTest {

    // keuntungan membuat lifecycle per class adalah
    // membuat before all dan after all tanpa perlu
    // menggunakan companion object dan jvmStatic

    @BeforeAll
    fun beforeAll(){}

    @AfterAll
    fun afterAll(){}

    var counter: Int = 0

    @Test
    fun test1() {
        counter++
        println(counter)
        println(this.hashCode())
    }

    @Test
    fun test2() {
        counter++
        println(counter)
        println(this.hashCode())
    }

    @Test
    fun test3() {
        counter++
        println(counter)
        println(this.hashCode())
    }
}