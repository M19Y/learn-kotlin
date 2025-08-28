package com.m19y

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope
import org.junit.jupiter.api.Test
import java.util.concurrent.Executors
import kotlin.coroutines.CoroutineContext

class ExceptionHandlerTest {

    @Test
    fun nestedCoroutineWrongExceptionHandlerTest() {

        val exceptionHandler: CoroutineExceptionHandler = CoroutineExceptionHandler { context, throwable ->
            println("Error: ${throwable.message}")
        }
        val dispatcher: CoroutineContext = Executors.newFixedThreadPool(10).asCoroutineDispatcher()
        val scope: CoroutineScope = CoroutineScope(dispatcher.plus(exceptionHandler)) // benar

        val job: Job = scope.launch(exceptionHandler) { // benar
            launch(exceptionHandler) { // salah
                println("Job Child")
                throw IllegalArgumentException("Something went wrong!")
            }
        }

        runBlocking {
            job.join()
        }
    }

    @Test
    fun nestedCoroutineWithSupervisorScopeExceptionHandlerTest() {

        val exceptionHandler: CoroutineExceptionHandler = CoroutineExceptionHandler { context, throwable ->
            println("Error: ${throwable.message}")
        }
        val dispatcher: CoroutineContext = Executors.newFixedThreadPool(10).asCoroutineDispatcher()
        val scope: CoroutineScope = CoroutineScope(dispatcher)

        val job: Job = scope.launch {
            supervisorScope {
                launch(exceptionHandler){ // benar
                    launch(exceptionHandler) { // tidak berguna
                        println("Job Child")
                        throw IllegalArgumentException("Something went wrong!")
                    }
                }
            }
        }

        runBlocking {
            job.join()
        }
    }


}