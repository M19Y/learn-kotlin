package com.m19y

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import java.util.Date

class SharedFlowTest {


    @Test
    fun createSharedFlowTest() {

        val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)

        val sharedFlow: MutableSharedFlow<Int> = MutableSharedFlow()

        // sender mengirim tiap 1 detik
        scope.launch {
            repeat(10){
                println("Sender     -----> $it -----> ${Date()}")
                sharedFlow.emit(it)
                delay(1_000)
            }
        }

        // reciver menerima tiap 1 detik
        scope.launch {
            sharedFlow.asSharedFlow()
                .map { "Receiver 1 -----> $it -----> ${Date()}" }
                .collect {
                    delay(1_000)
                    println(it)
                }
        }

        // reciver menerima tiap 3 detik
        scope.launch {
            sharedFlow.asSharedFlow()
                .map { "Receiver 2 -----> $it -----> ${Date()}" }
                .collect {
                    delay(3_000)
                    println(it)
                }
        }

        runBlocking {
            delay(32_000)
        }
    }

    @Test
    fun createSharedFlowWithBufferTest() {

        val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)

        val sharedFlow: MutableSharedFlow<Int> = MutableSharedFlow()

        // sender mengirim tiap 1 detik
        scope.launch {
            repeat(10){
                println("Sender     -----> $it -----> ${Date()}")
                sharedFlow.emit(it)
                delay(1_000)
            }
        }

        // reciver menerima tiap 1 detik
        scope.launch {
            sharedFlow.asSharedFlow()
                .buffer(10)
                .map { "Receiver 1 -----> $it -----> ${Date()}" }
                .collect {
                    delay(1_000)
                    println(it)
                }
        }

        // reciver menerima tiap 3 detik
        scope.launch {
            sharedFlow.asSharedFlow()
                .buffer(10)
                .map { "Receiver 2 -----> $it -----> ${Date()}" }
                .collect {
                    delay(3_000)
                    println(it)
                }
        }

        runBlocking {
            delay(32_000)
        }
    }


}