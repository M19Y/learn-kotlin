package com.m19y

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import java.util.Date

class CancelableCoroutineTest {

    @Test
    fun cannotCancelTest() {
        runBlocking {
            val job: Job = GlobalScope.launch {
                println("Start coroutine ${Date()}")
                Thread.sleep(4_000)
                println("End coroutine ${Date()}")
            }

            job.cancel()
            delay(5_000)
        }
    }


    @Test
    fun cancelableWithActiveCheckingTest() {

        runBlocking {
            val job: Job = GlobalScope.launch {
                if(!isActive) throw CancellationException()
                println("Start coroutine ${Date()}")
                ensureActive()
                Thread.sleep(4_000)
                ensureActive()
                println("End coroutine ${Date()}")
            }

            job.cancel()
            delay(5_000)
        }
    }

    @Test
    fun cancelableFinallyWithCancelJoinTest() {
        runBlocking {
            val job: Job = GlobalScope.launch {
                try {
                    println("Start coroutine ${Date()}")
                    delay(2_000)
                    println("End coroutine ${Date()}")
                }finally {
                    println("Finally called")
                }
            }

            job.cancelAndJoin()
        }
    }
}