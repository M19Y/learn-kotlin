package com.m19y

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class CoroutineScopeTest {

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun createScopeTest() {

        val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)

        scope.launch {
            delay(1_000)
            println("Scope 1 Run : ${Thread.currentThread().name}")
        }

        scope.launch {
            delay(1_000)
            println("Scope 2 Run : ${Thread.currentThread().name}")
        }

        GlobalScope.launch {
            delay(1_000)
            println("Bro")
        }

        runBlocking {
            println("Start")
            delay(2_000)
            println("Done")
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun cancelScopeTest() {

        val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)

        scope.launch {
            delay(2_000)
            println("Scope 1 Run : ${Thread.currentThread().name}")
        }

        scope.launch {
            delay(2_000)
            println("Scope 2 Run : ${Thread.currentThread().name}")
        }

        GlobalScope.launch {
            delay(2_000)
            println("Bro")
        }

        runBlocking {
            println("Start")
            delay(1_000)
            scope.cancel()
            delay(2_000)
            println("Done")
        }
    }

    
}