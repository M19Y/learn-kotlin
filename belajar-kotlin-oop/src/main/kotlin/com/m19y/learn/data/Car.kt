package com.m19y.learn.data

class Car(paramBrand:String,
    paramYear:Int = 2020) {

    // initializer block
    init {
        println("Car $paramBrand dibuat")
    }
    var band:String = paramBrand
    var year:Int = paramYear
}