package com.m19y.learn.data

interface Interaction {
    abstract val name: String
    abstract fun sayHello(name: String): Unit // wajib di implement

    // default method kalau di java (opsional diimpementasi sama turunannya)
    fun sayMorning(name: String): Unit {
        println("Good Morning $name")
    }
}
interface A{
}
interface B{
}

interface C{
    fun move() = println("Move C")
}
interface D{
    fun move() = println("Move D")
}
interface Go: A, B {
    fun go(){
        println("Go!")
    }
}

open class Weird

class Human(override val name: String): Interaction, Go, C, D, Weird() {
    override fun sayHello(name: String) {
        println("Hello $name")
    }

    override fun move() {
        super<C>.move()
        super<D>.move()
        println("Human Move")
    }

//    override fun sayMorning(name: String) {
//        println("Gooood Morning $name")
//    }
}

