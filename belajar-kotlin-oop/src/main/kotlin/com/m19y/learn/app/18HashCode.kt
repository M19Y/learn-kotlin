package com.m19y.learn.app

import com.m19y.learn.data.Company

fun main() {

    val company1 = Company("M19Y")
    val company2 = Company("M19Y")

    println(company1)
    println(company2)

    println(company1.hashCode())
    println(company2.hashCode())

    println(company1.hashCode() == company2.hashCode())

}