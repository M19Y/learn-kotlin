package com.m19y

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future
import kotlin.system.measureTimeMillis

class FutureTest {

    fun getFoo(): Int {
        Thread.sleep(1000)
        return 10
    }

    fun getBar(): Int {
        Thread.sleep(1000)
        return 10
    }

    @Test
    fun sequentialTest() {

        val time: Long = measureTimeMillis {
            val foo = getFoo()
            val bar = getBar()
            val result = foo + bar
            println("result = $result")
        }
        println("Total time = $time")

    }

    @Test
    fun parallelWithCallbackFutureTest() {
        val executorService: ExecutorService = Executors.newFixedThreadPool(10)

        val sequentialTime: Long = measureTimeMillis {
            val foo = getFoo()
            val bar = getBar()
            val result = foo + bar
            println("result = $result")
        }

        println("Total time = $sequentialTime")

        val parallelTime: Long = measureTimeMillis {
            val foo: Future<Int> = executorService.submit<Int>(Callable { getFoo() })
            val bar: Future<Int> = executorService.submit<Int>(Callable { getBar()})
//            val bar: Future<Int> = executorService.submit { getBar() }
            val result = foo.get() + bar.get()

            println("result = $result")
        }

        println("Total time = $parallelTime")

        Assertions.assertTrue(sequentialTime > parallelTime)
    }
}