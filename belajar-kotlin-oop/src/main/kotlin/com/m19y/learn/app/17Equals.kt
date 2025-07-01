package com.m19y.learn.app

import com.m19y.learn.data.Company

fun main() {

    val company1 = Company("M19Y")
    val company2 = Company("M19Y")

    // setelah melakukan override method equals pada company class
    println(company1 == company2) // true
    println(company1.equals(company2)) // true

    println(company1.equals("M19Y")) // false
}