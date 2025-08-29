package app

import data.Fruit

fun main() {
    val mango = Fruit("Mango", 10)
    val apple = Fruit("Apple", 15)

    println(mango < apple)
    println(mango > apple)
}