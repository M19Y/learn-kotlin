package com.m19y

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ExceptionTest {

    // launch tidak akan memberi tahu apabila terjadi error
    // sedangkan async akan memberi tahu terjadi error, dan harus di catch

    @Test
    fun launchExceptionTest() {

        val job: Job = GlobalScope.launch {

            println("Start a job")
            throw IllegalArgumentException("Something went wrong!")

        }
        runBlocking {
            println("Program started")
            job.join()
            println("Program ended")
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun asyncExceptionTest() {

        val job = GlobalScope.async {
            println("Start coroutine")
            throw IllegalArgumentException("Something went wrong!")
        }

//        Assertions.assertThrows<IllegalArgumentException>(IllegalArgumentException::class.java) {
//            runBlocking {
//                println("Start Program error")
//                job.await()
//                println("End program error")
//            }
//        }

        runBlocking {
            try {
                println("Start Program")
                job.await()
            } catch (error: IllegalArgumentException) {
                println("Error: ${error.message}")
            } finally {
                println("End Program")
            }
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun launchExceptionHandlerTest() {
        val exceptionHandler: CoroutineExceptionHandler = CoroutineExceptionHandler { context, throwable ->
            println("Error: ${throwable.message}")
        }

        val job: Job = GlobalScope.launch(exceptionHandler + Dispatchers.IO) {
            println("Start a job")
            throw IllegalArgumentException("Something went wrong!")
        }

        runBlocking {
            println("Start Program")
            job.join()
            println("End Program")
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun launchExceptionHandlerWithTryCatchTest() {

        val job: Job = GlobalScope.launch(Dispatchers.IO) {
            println("Start a job")
            throw IllegalArgumentException("Something went wrong!")
        }

        runBlocking {
            try {
                println("Start program")
                job.join()
            } catch (error: IllegalArgumentException) {
                println("Error bro ${error.message}") // error ini tidak berguna sama sekali, karena join() method tidak melempar error
            } finally {
                println("End program")
            }
        }

        // tidak mengembalikan error sama sekali
        Assertions.assertDoesNotThrow {
            runBlocking { job.join() }
        }
    }
}