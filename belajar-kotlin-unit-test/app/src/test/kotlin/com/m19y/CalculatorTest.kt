package com.m19y

import com.m19y.generator.SimpleDisplayNameGenerator
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assumptions
import org.junit.jupiter.api.*

import org.junit.jupiter.api.Test
import org.opentest4j.TestAbortedException

@DisplayNameGeneration(value = SimpleDisplayNameGenerator::class)
class CalculatorTest {

    companion object{
        @BeforeAll
        @JvmStatic
        fun beforeAll() {
            println("Before all")
        }

        @AfterAll
        @JvmStatic
        fun afterAll() {
            println("After all")
        }
    }
    val calculator: Calculator = Calculator();


    @BeforeEach
    fun setUp() {
        println("Before each")
    }

    @AfterEach
    fun tearDown() {
        println("After each")
    }

    @Test
    fun shouldReturn20_when9Plus11(){
        println("shouldReturn20_when9Plus11")
        Assertions.assertEquals(20, calculator.add(9, 11))
    }

    @Test
    fun shouldReturn20_when9Plus11_2(){
        println("shouldReturn20_when9Plus11_2")
        Assertions.assertEquals(20, calculator.add(9, 11))
    }

    @Test
    fun shouldThrowError_whenSecondParamIsZero_usedJava() {
        println("shouldThrowError_whenSecondParamIsZero_usedJava")
        val ex = Assertions.assertThrows(
            IllegalArgumentException::class.java
        ) { calculator.divide(9, 0) }

        println(ex.message)
    }

    @Test
    fun shouldThrowError_whenSecondParamIsZero_usedKotlin() {
        println("shouldThrowError_whenSecondParamIsZero_usedKotlin")
        val ex = assertThrows<IllegalArgumentException> { calculator.divide(11, 0)}
        Assertions.assertEquals("Can not divide by zero", ex.message)
    }

    @Test
    @Disabled(value = "Do it later")
    fun comingSoonTest() {
        println("Coming Soon")
        // uncompleted task
    }

    @Test
    fun testAborted() {
        println("Start")
        val profile = System.getenv("PROFILE")
        if(profile != "DEV") throw TestAbortedException()
        println("finish")
    }

    @Test
    fun testAssumption() {
        println("Start")
        // kalau ini true maka akan dilanjutkan, jika tidak maka akan di disable
        Assumptions.assumeTrue("DEV" == System.getenv("PROFILE"))
        println("finish")
    }
}