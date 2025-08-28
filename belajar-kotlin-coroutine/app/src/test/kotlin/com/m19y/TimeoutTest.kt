package com.m19y

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.withTimeoutOrNull
import org.junit.jupiter.api.Test
import java.util.Date
import kotlin.time.Duration

class TimeoutTest {

    @Test
    fun timeoutAfter5SecUsingWithTimeoutTest() {

        runBlocking {
            val job: Job = GlobalScope.launch {
                println("Start coroutine")
                withTimeout(5_000) {
                    repeat(100) {
                        delay(1_000)
                        println("$it ${Date()}")
                    }
                }
                println("End coroutine") // tidak akan di eksekusi karena sudah keburu timeout
                // kalau mau bisa pakai try and finally
            }

            job.join()
        }
    }

    @Test
    fun timeoutAfter5SecUsingWithTimeoutOrNullTest() {

        runBlocking {
            val job: Job = GlobalScope.launch {
                println("Start coroutine")
                // hanya memberhentikan block codenya saja, tidak memberhentikan coroutinennya
                withTimeoutOrNull(5_000) {
                    repeat(100) {
                        delay(1_000)
                        println("$it ${Date()}")
                    }
                }
                println("End coroutine") // akan tetap di eksekusi
            }

            job.join()
        }
    }
}