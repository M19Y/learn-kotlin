package com.m19y.learn.app

import com.m19y.learn.data.Action

fun fireAction(action: Action){
    action.action()
}
// normal class
class SimpleAction : Action{
    override fun action() {
        println("Do it in simple class")
    }
}
fun main() {
    // membuat class terleih dahulu
    fireAction(SimpleAction())

    // menggunakan annonymous class
    fireAction(object: Action {
        override fun action() = println("Do it in anonymous 1")
    })

    fireAction(object: Action {
        override fun action() = println("Do it in anonymous 2")
    })
}