package com.m19y.learn.app

import com.m19y.learn.data.User

fun main() {
    val user1 = User("bro", "secret")
    val user2 = User("sis", "secret")

    user1.password = "secret123" // bisa di modify juga
    println(user1.username)
    println(user1.password)

    println(user2.username)
    println(user2.password)
}