package com.m19y.learn.app

import com.m19y.learn.data.Car

fun main() {

    val avanza = Car("Toyota")
    avanza.year = 2025

    val almaz = Car("Wuling", 2021)

    println(avanza.band)
    println(avanza.year)

    println(almaz.band)
    println(almaz.year)
}