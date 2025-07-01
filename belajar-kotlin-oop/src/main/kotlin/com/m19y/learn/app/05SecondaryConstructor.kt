package com.m19y.learn.app

import com.m19y.learn.data.Address

fun main() {

    // hanya memanggil secondary dan primary constructor
    val myAddress = Address("Monas No1 ","Jakarta")
    println(myAddress.country)
    println(myAddress.city)
    println(myAddress.street)

    println("\n")
    // akan memanggil semua constructor
    val herAddress = Address("Cilengsi No1")
    println(herAddress.country)
    println(herAddress.city)
    println(herAddress.street)
}
