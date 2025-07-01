package com.m19y.learn.data

class Game(val name: String, val price: Int) {
    // create component manual
    operator fun component1(): String = name
    operator fun component2(): Int = price
}