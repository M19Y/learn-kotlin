package com.m19y.learn.app

import com.m19y.learn.data.Fruit

fun main() {

    // operator overloading adalah kemampuan mengubah function
    // menjadi operator aritmatika, unary prefix, increment & decrement dan lain lain
    val totalQuantity:Int = Fruit(100) + Fruit(15)
    println(totalQuantity) // 115

    val fruitMinus: Fruit = Fruit(9) - Fruit(11)
    println(fruitMinus) // -2

    println("\nIncrement & Decrement")

    var incFruit = Fruit(1)
    incFruit++
    incFruit++
    incFruit++
    println(incFruit)
}