package com.m19y.learn.app

import com.m19y.learn.data.Game
import com.m19y.learn.data.Login
import com.m19y.learn.data.MinMax

fun minMax(value1: Int, value2: Int): MinMax {
    return when {
        value1 > value2 -> MinMax(value2, value1)
        else -> MinMax(value1, value2)
    }
}

fun login(login: Login, callback: (Login) -> Boolean): Boolean = callback(login)

fun main() {
    val game = Game("Bro", 10)
    val (name, price) = game
    println(price)
    println(name)

    println("\nMin Max values")
    val (min, max) = minMax(9, 11)
    println(min) // 9
    println(max) // 11

    val (min1, max1) = minMax(10, 3)
    println(min1) // 3
    println(max1) // 10

    println("\nLogin")
    val login = Login("Bro", "Secret")

    // without destructuring
    val isSuccess = login(login) { login ->
        login.username == "Bro" && login.password == "Secret"
    }

    val isSuccess2 = login(login) {(username, password) -> username == "Bro" && password == "Secret"}

    println(isSuccess)
    println(isSuccess2)
}
