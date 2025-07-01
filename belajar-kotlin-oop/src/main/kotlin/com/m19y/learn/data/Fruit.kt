package com.m19y.learn.data

data class Fruit(val quantity: Int) {

    // arithmetic
    operator fun plus(fruit: Fruit): Int = this.quantity + fruit.quantity
    operator fun minus(fruit: Fruit): Fruit = Fruit(this.quantity - fruit.quantity)

    // increment decrement
    operator fun inc(): Fruit = Fruit(quantity + 1)
}