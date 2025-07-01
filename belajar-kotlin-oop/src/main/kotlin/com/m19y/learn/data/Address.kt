package com.m19y.learn.data

class Address(street:String, city:String, country:String) {

    var street:String = street
    var city:String = city
    val country:String = country

    init {
        println("Akan di eksekusi pertama kali Initializer block")
    }

    // secondary constructor
    constructor(street:String, city: String): this(street, city, "Indonesia"){
        // kita bisa menuli kode disini
        println("Secondary constructor 2 parameter")
    }

    // kita bisa membuat secondary konstructor sebanyak banyaknya
    constructor(street: String) : this(street, ""){
        println("Secondary constructor 1 parameter")
    }
}