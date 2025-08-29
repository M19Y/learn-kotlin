package com.m19y.learn.app

import com.m19y.learn.data.Rectangle

fun main() {

    // super key word adalah kemampan child class
    // untuk memngakses properties/function pada parent class-nya
    // super key word hanya bisa mengakes 1 parent diatasnya
    // example: super.corner (ini bisa)
    // super key word tidak bisa mengakse 2 parent diatasnya atau lebih
    // example: super.super.corner (ini tidak bisa)

    val rectangle = Rectangle();
    println("Corner: ${rectangle.corner}")
    println("Parent Corner: ${rectangle.parentCorner}")
    rectangle.printName()
}