package com.m19y

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.util.concurrent.Executors
import kotlin.coroutines.CoroutineContext

class CoroutineScopeFunctionTest {

    suspend fun foo(): Int {
        delay(1_000)
        println("Foo ${Thread.currentThread().name}")
        return 10
    }

    suspend fun bar(): Int {
        delay(1_000)
        println("Bar ${Thread.currentThread().name}")
        return 10
    }

    suspend fun longSum(): Int {
        val context: CoroutineContext = Executors.newSingleThreadExecutor().asCoroutineDispatcher()
        val scope: CoroutineScope = CoroutineScope(context = context)
        val foo: Deferred<Int> = scope.async { foo() }
        val bar: Deferred<Int> = scope.async { bar() }
        return foo.await() + bar.await()
    }

    suspend fun sum(): Int {
        return coroutineScope {
            val foo = async { foo() }
            val bar = async { bar() }
            foo.await() + bar.await()
        }
    }

    // coroutineScope contextnya akan mengikuti context scope yang memanggilnya
    suspend fun simpleSum(): Int = coroutineScope {
        val foo = async { foo() }
        val bar = async { bar() }
        foo.await() + bar.await()
        // simpleSum disini dijalankan Dispachers.io maka scope dari coroutineScopenya adalah IO
        // lihat contoh test: coroutineScopeTest dibawah!
    }

    @Test
    fun coroutineScopeTest() {

        val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)

        val job: Job = scope.launch {
            val longSum = longSum() // tidak mengikuti context scope
            val standardSum = sum() // mengikuti context scope
            val simpleSum = simpleSum() // mengikuti context scope

            println("Long Sum => $longSum")
            println("Standard Sum => $standardSum")
            println("Simple Sum => $simpleSum")
        }

        runBlocking {
            job.join()
        }
    }

    @Nested
    inner class ParentChild {

        @Test
        fun parentChildDispatcherTest() {
            val dispatcherContext: CoroutineContext = Executors.newFixedThreadPool(10).asCoroutineDispatcher()
            val scope: CoroutineScope = CoroutineScope(context = dispatcherContext)

            val job: Job = scope.launch {
                println("Parent: ${Thread.currentThread().name}")
                coroutineScope {
                    launch {
                        println("Child: ${Thread.currentThread().name}")
                    }
                }
            }

            runBlocking {
                job.join()
            }
        }

        @OptIn(DelicateCoroutinesApi::class)
        @Test
        fun coroutineParentChildTest() {

            // parent child akan mengunggu semua child-nya selesai
            // walaupun itu tidak sequential
            val job: Job = GlobalScope.launch {
                println("Job Start")
                launch {
                    delay(4_000)
                    println("First Child: ${Thread.currentThread().name}")
                }
                launch {
                    delay(2_000)
                    println("Second Child: ${Thread.currentThread().name}")
                }
                delay(1_000)
                println("Job Ended")
            }

            runBlocking {
                job.join()
            }


        }

        @OptIn(DelicateCoroutinesApi::class)
        @Test
        fun cancelChildTest() {
            val job: Job = GlobalScope.launch {
                println("Job Start")
                launch {
                    delay(4_000)
                    println("First Child: ${Thread.currentThread().name}")
                }
                launch {
                    delay(2_000)
                    println("Second Child: ${Thread.currentThread().name}")
                }
                delay(1_000)
                println("Job Ended")
            }

            runBlocking {
                job.cancelChildren() // akan memberhentikan semua childnya
                job.join()
            }

        }
    }

}