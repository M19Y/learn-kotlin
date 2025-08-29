package com.m19y

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class FlowTest {


    @Test
    fun flowTest() {
        val flow: Flow<Int> = flow {

            println("Start Flow")
            repeat(100) {
                println("Send $it")
                emit(it)
            }
            println("End Flow")
        }

        runBlocking {
            flow.collect {
                println("Receive $it")
            }
        }
    }

    suspend fun numberFlow(): Flow<Int> {
        return flow {
            repeat(100) {
                emit(it)
            }
        }
    }

    suspend fun changeString(number: Int): String {
        delay(250)
        return "Number $number"
    }

    @Test
    fun flowOperationTest() {
        runBlocking {
            val flow: Flow<Int> = numberFlow()

            flow.filter { it % 2 == 0 }
                .map { changeString(it) }
                .collect { println(it) }

            val strFlow: Flow<String> = numberFlow()
                .filter { it % 2 == 0 }
                .map { changeString(it) }

            strFlow.collect { println(it) }
        }
    }

    @Test
    fun flowExceptionTest() {

        runBlocking {
            numberFlow()
                .map { check(it < 10); it }
                .onEach { println(it) }
                .catch { println("error ${it.message}") }
                .onCompletion { println("finally Complete") }
                .collect()
        }
    }

    @Test
    fun cancelFlowTest() {

        val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)

        runBlocking {
            scope.launch {
                numberFlow()
                    .onEach {
                        if(it > 10) cancel()
                        else println(it)
                    }.collect()
            }
        }
    }
}