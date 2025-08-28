package com.m19y

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope
import org.junit.jupiter.api.Test
import java.util.concurrent.Executors
import kotlin.coroutines.CoroutineContext

class SupervisorJobTest {

    @Test
    fun defaultJobWillThrowAnErrorWhenOneOfTheCoroutineFailed() {
        val dispatcher: CoroutineContext = Executors.newFixedThreadPool(10).asCoroutineDispatcher()
        val scope: CoroutineScope = CoroutineScope(dispatcher + Job())

        val job1: Job = scope.launch {
            delay(2000)
            println("Run Job 1: ${Thread.currentThread().name}") // this won't running
        }

        val job2: Job = scope.launch {
            delay(1000)
            throw IllegalArgumentException("Something Went Wrong!")
        }

        runBlocking {
            println("Start Program")
            joinAll(job1, job2)
            println("End Program")
        }
    }

    @Test
    fun supervisorJobWontThrowAnErrorWhenOneOfTheCoroutineFailed() {
        val dispatcher: CoroutineContext = Executors.newFixedThreadPool(10).asCoroutineDispatcher()
        val scope: CoroutineScope = CoroutineScope(dispatcher + SupervisorJob())

        val job1: Job = scope.launch {
            delay(2000)
            println("Run Job 1: ${Thread.currentThread().name}") // this will still running
        }

        val job2: Job = scope.launch {
            delay(1000)
            throw IllegalArgumentException("Something Went Wrong!")
        }

        runBlocking {
            println("Start Program")
            joinAll(job1, job2)
            println("End Program")
        }
    }

    @Test
    fun changeDefaultJobToSupervisorJob() {
        val dispatcher: CoroutineContext = Executors.newFixedThreadPool(10).asCoroutineDispatcher()
        val scope: CoroutineScope = CoroutineScope(dispatcher + Job())

        runBlocking {
            scope.launch {
                supervisorScope {
                    launch {
                        delay(2000)
                        println("Run Job 1: ${Thread.currentThread().name}")
                    }

                    launch {
                        delay(1000)
                        throw IllegalArgumentException("Something Went Wrong!")
                    }
                }
            }
            println("Start Program")
            delay(4_000)
            println("End Program")
        }
    }
}