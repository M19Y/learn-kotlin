package com.m19y.learn.app

inline class Token(val name:String){
    fun makeItBig(): String = name.uppercase()
}

fun Token.simple(){
    println("it can")
}
val Token.bro:String
    get() = "Simple properties"

fun main() {
    val token = Token("Bro")
    println(token.name)
    println(token.makeItBig())

    token.simple()
    println(token.bro)
}