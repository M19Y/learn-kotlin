package com.m19y

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class CoroutineDispatcherTest {

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun coroutineDispatcherTest() {
        println("Test Thread -> ${Thread.currentThread().name}\n")

        runBlocking {
            println("Run blocking thread: ${Thread.currentThread().name}\n")

            val job1: Job = GlobalScope.launch(context = Dispatchers.Default) {
                println("Job 1 thread: ${Thread.currentThread().name}\n")
            }

            val job2: Job = GlobalScope.launch(context = Dispatchers.IO) {
                println("Job 2 thread: ${Thread.currentThread().name}\n")
            }
            joinAll(job1, job2)

        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun unconfinedDispatcherTest() {

        runBlocking {
            println("Start========\n")
            println("Run blocking: ${Thread.currentThread().name}")

            // akan berubah threadnya
            GlobalScope.launch(context = Dispatchers.Unconfined) {
                repeat(2) {
                    println("Unconfined: ${Thread.currentThread().name}")
                    delay(1_000)
                    println("Unconfined: ${Thread.currentThread().name}")
                }
            }

            // tidak akan berubah threadnya
            GlobalScope.launch { // by default, Dispatchers-nya adalah Confined
                repeat(2) {
                    println("Confined: ${Thread.currentThread().name}")
                    delay(1_000)
                    println("Confined: ${Thread.currentThread().name}")
                }
            }

            delay(3_000)
            println("\nFinish========")
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun customDispatcherTest() {
        val dispatcherService: ExecutorService = Executors.newFixedThreadPool(10)

        val dispatcherServiceCoroutine: CoroutineDispatcher = dispatcherService.asCoroutineDispatcher()
        val dispatcherWeb: CoroutineDispatcher = Executors.newSingleThreadExecutor().asCoroutineDispatcher()

        runBlocking {
            val job1: Job = GlobalScope.launch(context = dispatcherServiceCoroutine) {
                println("Job 1 : ${Thread.currentThread().name}")
            }

            val job2: Job = GlobalScope.launch(context = dispatcherWeb) {
                println("Job 2: ${Thread.currentThread().name}")
            }

            joinAll(job1, job2)
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    @DisplayName("Change thread in the middle of execution")
    fun withContextTest() {
        val dispatcherClient: CoroutineDispatcher = Executors.newFixedThreadPool(10).asCoroutineDispatcher()

        runBlocking {
            val job: Job = GlobalScope.launch(context = Dispatchers.IO) {
                println("1: ${Thread.currentThread().name}")

                // with context akan mengubah thread yang akan diggunakan untuk mengeksekusi block code
                withContext(context = dispatcherClient) {
                    println("2: ${Thread.currentThread().name}")
                }

                println("3: ${Thread.currentThread().name}")

                delay(1_000) // delay akan di jalankan di thread lain

                println("4: ${Thread.currentThread().name}")
            }

            job.join()
        }
    }
}