package com.m19y

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

class SequentialSuspendFunctionTest {
    // suspend function itu tidak berjalan secara parallel
    // suspend function itu hanya function yang bisa di tangguhkan pekerjaannya
    suspend fun getFoo(): Int {
        delay(1000)
        return 10
    }

    suspend fun getBar(): Int {
        delay(1000)
        return 10
    }

    fun getFooBar():Int{
//        delay(1000)
        Thread.sleep(1000)
        return 10
    }

    @Test
    fun executeSuspendFunctionTimeTest() {
        runBlocking {
            val totalTime: Long = measureTimeMillis {
                getFoo()
                getBar()
            }
            println("Total execution time: $totalTime")
            Assertions.assertTrue(2000 <= totalTime)
        }
    }

    @Test
    fun executeSuspendFunctionInsideCoroutinesTest() {
        runBlocking {
            val totalTime: Long = measureTimeMillis {
                val job1: Job = GlobalScope.launch { getFoo() }
                val job2: Job = GlobalScope.launch { getBar() }
                val job3: Job = GlobalScope.launch { getFooBar() }
                joinAll(job1, job2, job3)
            }

            println("Total execution time: $totalTime")
            Assertions.assertTrue(2000 > totalTime)

        }
    }
}