package com.m19y

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.junit.jupiter.api.Test

class CoroutineNameTest {

    @Test
    fun createNameTest() {
        val scope1 = CoroutineScope(Dispatchers.IO + CoroutineName("Grandpa"))
        val scope2: CoroutineScope = CoroutineScope(Dispatchers.IO)

        val job: Job = scope2.launch(CoroutineName("Parent")) {

            println("Parent run in thread: ${Thread.currentThread().name}")
            withContext(CoroutineName("Child")){
                println("Child run in thread: ${Thread.currentThread().name}")
            }
        }

        runBlocking {
            job.join()
        }
    }
}