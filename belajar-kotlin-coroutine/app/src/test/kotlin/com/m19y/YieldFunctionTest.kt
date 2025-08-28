package com.m19y

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield
import org.junit.jupiter.api.Test
import java.util.concurrent.Executors
import kotlin.coroutines.CoroutineContext

class YieldFunctionTest {

    suspend fun runJob(number: Int){
        println("Start job $number in thread ${Thread.currentThread().name}")
        yield()
        println("End job $number in thread ${Thread.currentThread().name}")
    }

    @Test
    fun yieldFunctionTest() {
        val dispatcher: CoroutineContext = Executors.newFixedThreadPool(10).asCoroutineDispatcher()
        val scope: CoroutineScope = CoroutineScope(context = dispatcher)

        runBlocking {
            scope.launch { runJob(1) }
            scope.launch { runJob(2) }
            delay(2_000)
        }
    }
}