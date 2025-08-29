package com.m19y

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class ActorTest {

    @OptIn(ObsoleteCoroutinesApi::class)
    @Test
    fun createActorTest() {

        val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)

        val senderChannel: SendChannel<Int> = scope.actor<Int>(capacity = 10) {
            repeat(10){
                println("Actor recive data ==> ${receive()}")
            }
        }

        val job: Job = scope.launch {
            repeat(10){
                senderChannel.send(it)
            }
        }

        runBlocking {
            job.join()
        }
    }
}