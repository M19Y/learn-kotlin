package com.m19y

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInfo

@DisplayName(value = "Test with testInfo")
class InformationTest {

    @Test
    @Tags(value = [
        Tag("contoh1"),
        Tag("contoh2")
    ])
    @DisplayName(value = "Sample Info")
    fun sampleTest(info: TestInfo) {

        println(info.testMethod)
        println(info.tags)
        println(info.displayName)
        println(info.testClass)
    }
}