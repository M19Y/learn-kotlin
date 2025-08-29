package com.m19y

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.selects.select
import org.junit.jupiter.api.Test

class SelectTest {


    @Test
    fun selectDeferredTest() {

        val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)
        val deferred1: Deferred<Int> = scope.async {
            delay(1_000)
            1000
        }
        val deferred2: Deferred<Int> = scope.async {
            delay(2_000)
            2000
        }
        val deferred3: Deferred<Int> = scope.async {
            delay(500)
            500
        }

        val job: Job = scope.launch {
            val win: Int = select<Int> {
                deferred1.onAwait { it }
                deferred2.onAwait { it }
                deferred3.onAwait { it }
            }

            println("The winner is $win")
        }

        runBlocking {
            job.join()
        }

    }

    @Test
    fun selectChannelTest() {

        val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)
        val channel1: ReceiveChannel<Int> = scope.produce<Int>() {
            delay(1_000)
            send(1000)
        }
        val channel2: ReceiveChannel<Int> = scope.produce<Int>() {
            delay(2_000)
            send(2000)
        }
        val channel3: ReceiveChannel<Int> = scope.produce<Int>() {
            delay(500)
            send(500)
        }

        val job: Job = scope.launch {
            val win: Int = select<Int> {
                channel1.onReceive { it }
                channel2.onReceive { it }
                channel3.onReceive { it }
            }

            println("The winner is $win")
        }

        runBlocking {
            job.join()
        }

    }

    @Test
    fun selectChannelAndDeferredTest() {

        val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)
        val channel1: ReceiveChannel<Int> = scope.produce<Int>() {
            delay(1_000)
            send(1000)
        }
        val deferred2: Deferred<Int> = scope.async<Int>() {
            delay(2_000)
            2000
        }
        val deferred3: Deferred<Int> = scope.async<Int>() {
            delay(500)
            500
        }

        val job: Job = scope.launch {
            val win: Int = select<Int> {
                channel1.onReceive { it }
                deferred2.onAwait { it }
                deferred3.onAwait { it }
            }

            println("The winner is $win")
        }

        runBlocking {
            job.join()
        }

    }
}