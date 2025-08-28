package com.m19y

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class JobTest {

    @Test
    fun jobDefaultTest() {
        runBlocking {
            GlobalScope.launch {
                delay(2_000) // tidak melakukan blocking pada run block (karena sedang berjalan di coroutine yang lain)
                println("Coroutine Done ${Thread.currentThread().name}")
            }
        }
    }

    @Test
    fun jobLazyTest() {
        runBlocking {
            val job: Job = GlobalScope.launch(start = CoroutineStart.LAZY) {
                delay(2_000)
                println("Coroutine Done ${Thread.currentThread().name}")
            }

            job.start()

            delay(4_0000)
        }
    }

    @Test
    fun jobLazyWithJoinTest() {
        runBlocking {
            val job: Job = GlobalScope.launch(start = CoroutineStart.LAZY) {
                delay(2_000)
                println("Coroutine Done ${Thread.currentThread().name}")
            }

            // kita tidak perlu lagi membuat .start dan delay untuk menunggu 2 sec jobnya
            // job.start()
            // delay(4_0000)

            // kita bisa memksa prosesnya menunggu sampai  jobnya selesai dengan menggunakan .join()
            println("Menunggu response")
            job.join()
            println("Compelete")
        }
    }

    @Test
    fun jobCancelTest() {
        runBlocking {
            val job = GlobalScope.launch {
                delay(2_000)
                println("this will canceled bro ${Thread.currentThread().name}")

            }
            // meskipun sudah ditunggu, ini akan tetap di cancel
            job.cancel()
            delay(3_000)
        }
    }

    @Test
    fun jobWithJoinAll() {

        runBlocking {
            val job1: Job = GlobalScope.launch {
                delay(2_000)
                println("Job 1 ${Thread.currentThread().name}")
            }

            val job2: Job = GlobalScope.launch {
                delay(3_000)
                println("Job 2 ${Thread.currentThread().name}")
            }

            joinAll(job1, job2)

        }
    }
}