package com.m19y.learn.app

import com.m19y.learn.data.Barang

fun main() {
    val barang = Barang("Mouse", 2, "Tech")
    val barang2 = Barang("Mouse", 2, "Tech")

    println(barang == barang2)
    println(barang)
    println(barang.hashCode() == barang2.hashCode())

    val barang3 = barang2.copy(price = 10)
    println(barang3)
}