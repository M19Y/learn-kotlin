package com.m19y

import kotlinx.coroutines.Job
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class AwaitCancellationFunctionTest {

    @Test
    fun awaitCancellationFunctionTest() {

        runBlocking {
            val job: Job = this.launch {
                try {
                    println("Do something")
                    awaitCancellation()
                    println("Meehh") // tidak akan di eksekusi
                }finally {
                    println("Coroutine Cancelled")
                }
            }

            delay(5_000)
            job.cancelAndJoin()
        }
    }
}