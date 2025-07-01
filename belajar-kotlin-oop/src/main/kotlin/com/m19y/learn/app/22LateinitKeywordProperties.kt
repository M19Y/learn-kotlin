package com.m19y.learn.app

import com.m19y.learn.data.Television

fun main() {

    val television = Television()
    // println(television.brand) // ERROR -> UninitializedPropertyAccessException

    television.initBrand("LG")
    println(television.brand)


}