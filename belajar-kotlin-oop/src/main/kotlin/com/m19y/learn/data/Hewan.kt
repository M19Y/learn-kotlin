package com.m19y.learn.data

abstract class Hewan {
    abstract val name: String
    abstract fun run()
}

class Cat : Hewan() {
    override val name: String = "Cat"

    override fun run() {
        println("Cat run")
    }
}

class Dog : Hewan() {
    override val name: String = "Dog"

    override fun run() {
        println("Dog run")
    }
}