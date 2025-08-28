package com.m19y

import org.junit.jupiter.api.Test
import java.util.Date
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class ExecutorServiceTest {


    @Test
    fun singleThreadPoolTest() {

        val executorService: ExecutorService = Executors.newSingleThreadExecutor()

        repeat(10){
            val runnable: Runnable = Runnable {
                Thread.sleep(1000)
                println("Complete $it ${Thread.currentThread().name} at ${Date()}")
            }

            // tiap runnablenya di simpan di pool
            executorService.execute(runnable)

            // langsung di sent tanpa menunggu
            // proses menunggu adalah saat execute buka pada saat submit runnable-nya
            println("Sent to pool $it")
        }

        println("Waiting Process...")
        Thread.sleep(11_000)
        println("Complete...")
    }

    @Test
    fun fixedThreadPoolTest() {

        // akan di jalankan per tiga kali execute (karena threadnya ada 3)
        val executorService: ExecutorService = Executors.newFixedThreadPool(3)

        repeat(10){
            val runnable: Runnable = Runnable {
                Thread.sleep(1000)
                println("Complete $it ${Thread.currentThread().name} at ${Date()}")
            }
            executorService.execute(runnable)
            println("Sent to pool $it")
        }

        println("Waiting Process...")
        Thread.sleep(5_000)
        println("Complete...")
    }

    @Test
    fun cachedThreadPoolTest() {

        // akan di jalankan semuanya sampai memory habis
        val executorService: ExecutorService = Executors.newCachedThreadPool()

        repeat(100){
            val runnable: Runnable = Runnable {
                Thread.sleep(1000)
                println("Complete $it ${Thread.currentThread().name} at ${Date()}")
            }
            executorService.execute(runnable)
            println("Sent to pool $it")
        }

        println("Waiting Process...")
        Thread.sleep(5_000)
        println("Complete...")
    }

}