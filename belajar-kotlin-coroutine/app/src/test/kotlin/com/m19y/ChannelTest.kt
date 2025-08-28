package com.m19y

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class ChannelTest {

    @Test
    fun channelSendAndReceiveTest() {
        // channel akan mengirim data satu persatu
        // ini tidak akan langsung dikirim kembali kecuali channel buffernya sudah kosong
        // dan kalau ada yang memanggil maka channel bisa mengirim satu data lagi ke buffernya
        runBlocking {
            val channel: Channel<Int> = Channel<Int>()
            val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)

            val job1: Job = scope.launch {
                println("Send 1 message")
                channel.send(1)
                delay(2_000)
                println("Send 2 message")
                channel.send(2)
            }

            val job2: Job = scope.launch {
                channel.receive()
                println("Receive message 1")
                delay(5_000)
                channel.receive()
                println("Receive message 2")
            }

            joinAll(job1, job2)
            channel.close()
        }
    }

    @Test
    fun channelSendAndReceiveWithBufferedUnlimitedTest() {

        // walaupun receivernya lambat, sendernya tidak peduli
        // sender akan mengirim terush sampai dengan buffernya penuh jika menggunakan UNLIMITED

        runBlocking {
            val channel: Channel<Int> = Channel<Int>(capacity = Channel.UNLIMITED)
            val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)

            val job1: Job = scope.launch {
                println("Send 1 message")
                channel.send(1)
                println("Send 2 message")
                channel.send(2)
                println("Send 3 message")
                channel.send(3)
            }

            val job2: Job = scope.launch {
                channel.receive()
                println("Receive message 1")
                delay(3_000)
                channel.receive()
                println("Receive message 2")
                delay(5_000)
                channel.receive()
                println("Receive message 3")
            }

            joinAll(job1, job2)
            channel.close()
        }
    }

    @Test
    fun channelSendAndReceiveWithBufferedConflatedTest() {

        // akan mereplace dengan sender terbaru jika buffernya sudah penuh ( satu buffer)

        runBlocking {
            val channel: Channel<Int> = Channel<Int>(capacity = Channel.CONFLATED)
            val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)

            val job1: Job = scope.launch {
                println("Send 1 message")
                channel.send(1)
                println("Send 2 message")
                channel.send(2)
                println("Send 3 message")
                channel.send(3)
            }

            job1.join()

            val job2: Job = scope.launch {
                println("Receive message ${channel.receive()}") // receive 3
            }

            job2.join()
            channel.close()
        }
    }

    @Test
    fun channelBufferedTest() {
        runBlocking {
            val channel: Channel<Int> = Channel<Int>(capacity = 10, onBufferOverflow = BufferOverflow.DROP_OLDEST)
            val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)

            val job1: Job = scope.launch {
                println("Send 1 message")
                channel.send(1)
                println("Send 2 message")
                channel.send(2)
                println("Send 3 message")
                channel.send(3)
            }

            job1.join()

            val job2: Job = scope.launch {
                println("Receive message ${channel.receive()}") // receive 3
            }

            job2.join()
            channel.close()
        }
    }

    @Test
    fun undeliveredElementTest() {
        val channel: Channel<Int> = Channel<Int>(capacity = 10) { value ->
            println("Undelivered element $value") // lambda ini akan di call saat mengirim data yang gagal (saat channel di close)
        }

        channel.close()

        runBlocking {

            val job: Job = this.launch {
                channel.send(10)
                channel.send(100)
            }

            job.join()
        }


    }

    @Test
    fun withoutProduceTest() {
        val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)
        val channel: Channel<Int> = Channel(capacity = 10)

        val jobSender: Job = scope.launch {
            repeat(100){
                channel.send(it)
            }
        }

        val jobReceiver: Job = scope.launch {
            repeat(100){
                println(channel.receive())
            }
        }

        runBlocking {
            joinAll(jobSender, jobReceiver)
        }
    }

    @Test
    fun withProduceTest() {
        val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)

        val channelReceiver: ReceiveChannel<Int> = scope.produce() {
            repeat(100){
                send(it)
            }
        }

        val jobReceiver: Job = scope.launch {
            repeat(100){
                println(channelReceiver.receive())
            }
        }

        runBlocking {
            joinAll(jobReceiver)
        }
    }
}