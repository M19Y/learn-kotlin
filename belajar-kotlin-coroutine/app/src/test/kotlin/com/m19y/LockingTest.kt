package com.m19y

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.Semaphore
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.sync.withPermit
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.concurrent.Executors
import kotlin.coroutines.CoroutineContext

class LockingTest {

    @Test
    fun raceConditionTest() {

        var count: Int = 0;
        val dispatcher: CoroutineDispatcher = Executors.newFixedThreadPool(10).asCoroutineDispatcher()
        val scope: CoroutineScope = CoroutineScope(dispatcher)

        repeat(times = 100) {
            scope.launch {
                repeat(1_000) {
                    count++
                }
            }
        }

        runBlocking {
            delay(5_000)
            println("total count = $count")
        }

        Assertions.assertTrue(count < 100_000)

    }

    @Test
    fun mutexTest() {

        var count: Int = 0;
        val dispatcher: CoroutineDispatcher = Executors.newFixedThreadPool(10).asCoroutineDispatcher()
        val scope: CoroutineScope = CoroutineScope(dispatcher)
        val mutex: Mutex = Mutex()

        repeat(times = 100) {
            scope.launch {
                repeat(1_000) {
                    mutex.withLock {
                        count++
                    }
                }
            }
        }

        runBlocking {
            delay(5_000)
            println("total count = $count")
        }
        Assertions.assertEquals(100_000, count)

    }

    @Test
    fun semaphoreTest() {

        var count: Int = 0;
        val dispatcher: CoroutineDispatcher = Executors.newFixedThreadPool(10).asCoroutineDispatcher()
        val scope: CoroutineScope = CoroutineScope(dispatcher)
        val semaphore: Semaphore = Semaphore(permits = 2)

        repeat(times = 100) {
            scope.launch {
                repeat(1_000) {
                    semaphore.withPermit {
                        count++
                    }
                }
            }
        }

        runBlocking {
            delay(5_000)
            println("total count = $count")
        }
        // Assertions.assertEquals(100_000, count) // permits 1
        Assertions.assertTrue(count < 100_000) // permits 2 .. n

    }
}