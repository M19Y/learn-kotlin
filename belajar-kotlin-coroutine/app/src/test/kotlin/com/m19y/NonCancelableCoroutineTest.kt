package com.m19y

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.junit.jupiter.api.Test

class NonCancelableCoroutineTest {

    @Test
    fun wrongCodeTest() {
        runBlocking {
            val job: Job = GlobalScope.launch {
                try {
                    println("Start Job")
                    delay(1_000)
                    println("End Job")
                } finally {
                    println(isActive)
                    delay(1_000)
                    println("Finally Called") // finally tidak akan dipanggil karena sudah di cancle pada delay diatannya
                }
            }

            job.cancelAndJoin()
        }
    }

    @Test
    fun nonCancelableTest() {
        runBlocking {
            val job: Job = GlobalScope.launch {
                try {
                    println("Start Job")
                    delay(1_000)
                    println("End Job")
                } finally {
                    println(isActive) // false
                    withContext(context = NonCancellable){
                        println(isActive) // true (selalu return true)
                        delay(1_000)
                        println("Finally Called") // akan di panggil karena jalan di thread berbeda
                    }
                }
            }

            job.cancelAndJoin()
        }
    }
}