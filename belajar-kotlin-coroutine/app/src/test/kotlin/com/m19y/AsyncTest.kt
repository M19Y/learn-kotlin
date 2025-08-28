package com.m19y

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.system.measureTimeMillis

class AsyncTest {

    suspend fun getFoo(): Int {
        delay(1000)
        return 10
    }

    suspend fun getBar(): Int {
        delay(1000)
        return 10
    }

    @Test
    fun asyncTest() {
        runBlocking {
            val totalTime: Long = measureTimeMillis {
                val foo: Deferred<Int> = GlobalScope.async { getFoo() }
                val bar: Deferred<Int> = GlobalScope.async { getBar() }

                val result: Int = foo.await() + bar.await()

                Assertions.assertEquals(20, result)
                println("Result = $result")
            }

            Assertions.assertTrue(totalTime < 2000)
            println("Total execution time: $totalTime")
        }
    }

    @Test
    fun asyncWithAwaitAllTest() {
        runBlocking {
            val totalTime: Long = measureTimeMillis {
                val foo1: Deferred<Int> = GlobalScope.async { getFoo() }
                val bar1: Deferred<Int> = GlobalScope.async { getBar() }
                val foo2: Deferred<Int> = GlobalScope.async { getFoo() }
                val bar2: Deferred<Int> = GlobalScope.async { getBar() }

                // cara yang manual satu persatu
                val manResult: Int = foo1.await() + bar1.await() + foo2.await() + bar2.await()

                // cara yang otomatis
                val otoResult: List<Int> = awaitAll(foo1, bar1, foo2, bar2)

                // melakukan penjumlahan menggunakan sum collection operation
                val result: Int = otoResult.sum()

                Assertions.assertEquals(40, result)
                println("Result = $result")
            }

            Assertions.assertTrue(totalTime < 2000)
            println("Total execution time: $totalTime")
        }
    }
}