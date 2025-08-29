package com.m19y.learn.app

import com.m19y.learn.data.SmartPhone

fun main() {

    val smartPhone: SmartPhone = SmartPhone("Vivo", "Android")
    println(smartPhone.toString())
    println(smartPhone.hashCode())
}