package com.m19y.learn.data

class Application(val name: String) {

    object Utilities {
        fun makeSmall(word: String) = word.lowercase()
        /*fun simple(name: String){
            println("$name ${this.name}") // tidak bisa megakses properties parent-nya
        }*/
    }

    companion object{
        // anda tetap tidak bisa mengakses properteis parent-nya
        // fun helo(name: String) = println("$name hallo my name is ${this.name}")
        fun helo(name: String) = println("hallo $name")
    }

}