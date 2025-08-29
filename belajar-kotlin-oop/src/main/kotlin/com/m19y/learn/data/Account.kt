package com.m19y.learn.data

import kotlin.properties.Delegates

class Account(description: String = "") {
    val name:String by lazy {
        println("Call name")
        "Bro"
    }

    var description by Delegates.observable(description) { property, oldValue, newValue ->
        println("${property.name} changed from $oldValue to $newValue")
    }
}