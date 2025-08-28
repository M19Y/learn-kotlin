package com.m19y

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import java.util.Date

class StateFlowTest {

    @Test
    fun createSharedFlowWithBufferTest() {

        val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)

        val stateFlow: MutableStateFlow<Int> = MutableStateFlow(0)

        // sender mengirim tiap 1 detik
        scope.launch {
            repeat(10){
                println("Sender     -----> $it -----> ${Date()}")
                stateFlow.emit(it)
                delay(1_000)
            }
        }

        // receive tiap 3 detik
        scope.launch {
            stateFlow.asSharedFlow()
                .map { "Receiver   -----> $it -----> ${Date()}" }
                .collect {
                    println(it)
                    delay(3_000)
                }
        }

        runBlocking {
            delay(15_000)
        }
    }


}