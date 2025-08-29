package com.m19y

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout
import java.util.concurrent.TimeUnit

class SlowTest {


    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    fun slowTest() {
        println("Start")
        Thread.sleep(10_000)
        println("End")
    }
}