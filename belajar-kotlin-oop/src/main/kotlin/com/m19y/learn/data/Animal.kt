package com.m19y.learn.data

// secondary constructor (tanpa primary)
class Animal {

    var name:String = ""
    var age:Int = 0;

    constructor(paramName:String){
        println("constructor 1 param")
    }

    constructor(paramName:String, paramAge:Int): this(paramName){
        println("constructor 2 param")
        age = paramAge
    }

}
