package com.m19y.resolver

import com.m19y.Calculator
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.Extensions
import java.util.Random

@Extensions(value = [
    ExtendWith(RandomParameterResolver::class)
])
class DependencyInjectionTest {

    private val calculator: Calculator = Calculator()

    @Test
    fun randomClassTest(random: Random) {
        val first: Int = random.nextInt(1_000)
        val second: Int = random.nextInt(1_000)

        val result: Int = calculator.add(first, second)

        Assertions.assertEquals(result, first + second)
    }
}