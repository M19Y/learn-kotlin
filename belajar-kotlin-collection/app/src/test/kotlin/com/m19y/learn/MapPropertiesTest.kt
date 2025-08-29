package com.m19y.learn

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Application(map: Map<String, Any>){

    // delegate keys to a variables
    val name:String by map
    val version: Int by map
    val test: String by map
}

class MapPropertiesTest {

    val map = mapOf<String, Any>(
        "name" to "Learn Kotlin",
        "version" to 1.0,
    )

    @Test
    fun propertiesTest() {
        val app: Application = Application(map)

        Assertions.assertEquals("Learn Kotlin", app.name)
        Assertions.assertEquals(1, app.version)
        Assertions.assertThrows(NoSuchElementException::class.java) {
            app.test
        }
    }


}