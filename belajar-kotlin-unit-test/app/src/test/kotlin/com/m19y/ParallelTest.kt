package com.m19y

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Execution(value = ExecutionMode.CONCURRENT)
class ParallelTest {

    @Test
    fun firstTest() {
        println("first start")
        Thread.sleep(3000)
        println("first done")
    }

    @Test
    fun secondTest() {
        println("second start")
        Thread.sleep(3000)
        println("second done")
    }

    @Test
    fun thirdTest() {
        println("third start")
        Thread.sleep(3000)
        println("third done")
    }
}