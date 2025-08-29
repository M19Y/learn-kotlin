package com.m19y

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.util.Date
import kotlin.concurrent.thread

class CoroutineTest {

    suspend fun hello() {
        delay(1_000)
        println("Hello world")
    }

    @Test
    fun coroutineTest() {
        println("Start")
        // untuk menjalankan coroutine kita bisa menggunakan GlobalScope.launch
        GlobalScope.launch {
            hello()
        }


        println("Waiting")
        runBlocking {
            delay(2_000)
        }
        println("Finish")
    }

    @Nested
    inner class ThreadVsCoroutine{

        @Test
        fun testThread() {

            repeat(1000_000) {
                thread {
                    Thread.sleep(1_000)
                    println("Thread $it : ${Date()} -> ${Thread.currentThread().name}")
                }
            }

            println("Waiting")
            Thread.sleep(3_000)
            println("Completed")
        }

        @Test
        fun testCoroutine() {
            repeat(10_000) {
                GlobalScope.launch {
                    delay(1_000)
                    println("Coroutine $it : ${Date()} -> ${Thread.currentThread().name}")
                }
            }

            println("Waiting")
            runBlocking {
                delay(5_000)
            }
            println("Completed")
        }
    }
}