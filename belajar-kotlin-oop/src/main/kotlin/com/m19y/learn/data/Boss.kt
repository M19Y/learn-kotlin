package com.m19y.learn.data

class Boss(val name: String) {

    inner class Employee(val name: String){

        fun hi(name: String) =
            println("Hi $name, my name is ${this.name}, and my boss is ${this@Boss.name}")
    }
}