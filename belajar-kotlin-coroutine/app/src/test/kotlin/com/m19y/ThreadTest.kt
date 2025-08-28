package com.m19y

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.util.Date
import kotlin.concurrent.thread

class ThreadTest {

    @Nested
    inner class JavaThread{
        @Test
        fun getThreadNameTest() {
            val threadName:String = Thread.currentThread().name
            println("Thread running in $threadName")
            Assertions.assertEquals("Test worker", threadName)
        }

        @Test
        fun createThreadTest() {

            val runnable: Runnable = Runnable {
                println("Start at ${Date()}")
                Thread.sleep(2000)
                println("End at ${Date()}")
            }

            val thread: Thread = Thread(runnable)

            println("Start app")
            thread.start()

            println("Wait process")
            Thread.sleep(3000)

            println("Finish")
        }

        @Test
        fun multipleThreadTest(){
            val thread1 = Thread {
                println("Start at ${Date()}")
                Thread.sleep(2000)
                println("Finis Thread 1 ${Thread.currentThread().name} at ${Date()}")
            }
            val thread2 = Thread( {
                println("Start at ${Date()}")
                Thread.sleep(2000)
                println("Finis Thread 2 ${Thread.currentThread().name} at ${Date()}")
            })

            thread1.start()
            thread2.start()

            println("Wait process")
            Thread.sleep(3000)
            println("Complete process")



        }
    }


    @Nested
    inner class KotlinThread{
        @Test
        fun kotlinThreadTest() {
            println("Start app")

            thread(start = true) {
                println("Start at ${Date()}")
                Thread.sleep(2000)
                println("End at ${Date()}")
            }

            println("Wait process")
            Thread.sleep(3000)

            println("Finish")
        }
    }

}