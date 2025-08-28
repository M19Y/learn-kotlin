package com.m19y

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

class CoroutineContextTest {

    @Test
    fun coroutineContextTest() {
        runBlocking {
            val job: Job = GlobalScope.launch {
                val context = coroutineContext
                println(context)
                println(context.get(Job))
                println(context.get(CoroutineDispatcher))
            }
            job.join()
        }
    }
}