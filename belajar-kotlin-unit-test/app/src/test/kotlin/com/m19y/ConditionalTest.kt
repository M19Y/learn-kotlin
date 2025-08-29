package com.m19y

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.condition.DisabledForJreRange
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable
import org.junit.jupiter.api.condition.DisabledIfSystemProperties
import org.junit.jupiter.api.condition.DisabledIfSystemProperty
import org.junit.jupiter.api.condition.DisabledOnJre
import org.junit.jupiter.api.condition.DisabledOnOs
import org.junit.jupiter.api.condition.EnabledForJreRange
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable
import org.junit.jupiter.api.condition.EnabledIfSystemProperty
import org.junit.jupiter.api.condition.EnabledOnJre
import org.junit.jupiter.api.condition.EnabledOnOs
import org.junit.jupiter.api.condition.JRE
import org.junit.jupiter.api.condition.OS

class ConditionalTest {

    @Test
    @EnabledOnOs(value = [OS.WINDOWS])
    fun shouldEnabled_whenOsIsWindows() {
        // hanya akan jalan apabila osnya adalah windows
    }

    @Test
    @DisabledOnOs(value = [OS.WINDOWS, OS.MAC])
    fun shouldDisabled_whenOsIsWindowsAndMac() {
        // tidak akan jalan pada Windows dan Mac, selain itu akan jalan
    }

    @Test
    @DisabledOnJre(value = [JRE.JAVA_21])
    fun shouldDisabled_whenJREis21() {

    }

    @Test
    @EnabledOnJre(value = [JRE.JAVA_21])
    fun shouldEnabled_whenJREis21() {

    }

    @Test
    @DisabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_21)
    fun shouldDisabled_whenJREIsBetween11And21() {
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_21)
    fun shouldEnabled_whenJREIsBetween11And21() {
    }

    @Test
    @DisabledIfSystemProperties(value = [
        DisabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    ])
    fun shouldDisabled_whenSystemPropertyJavaVendorIsOracle() {
    }

    @Test
    @EnabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    fun shouldEnabled_whenSystemPropertyJavaVendorIsOracle() {
    }

    @Test
    @DisabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    fun shouldDisabled_whenProfileIsDev() {
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    fun shouldEnabled_whenProfileIsDev() {
    }
}
