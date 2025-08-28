package com.m19y

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import java.util.Date

class SuspendFunctionTest {

    // suspend function must be called inside suspend function also
    suspend fun sayHelloWorld(){
        println("Hello ${Date()} -> ${Thread.currentThread().name}")
        delay(2_000)
        println("World ${Date()} -> ${Thread.currentThread().name}")
    }

    @Test
    fun suspendFunctionTest() {

        runBlocking {
            sayHelloWorld()
        }
    }
}