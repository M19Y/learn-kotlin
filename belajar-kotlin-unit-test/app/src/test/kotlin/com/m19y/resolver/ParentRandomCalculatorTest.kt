package com.m19y.resolver

import com.m19y.Calculator
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.Extensions

@Extensions(value = [
    ExtendWith(RandomParameterResolver::class)
])
abstract class ParentRandomCalculatorTest {

    protected val calculator: Calculator = Calculator()


    @BeforeEach
    fun setUp() {
        println("Before each called")
    }
}