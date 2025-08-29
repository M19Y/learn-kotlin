package com.m19y.learn.app

import com.m19y.learn.data.HandPhone
import com.m19y.learn.data.Laptop
import com.m19y.learn.data.SmartPhone

fun printAny(any: Any) = println(any)
fun printAnyWithIf(any: Any){
    if(any is Laptop){
        // kotlin memiliki kemampuan untuk mengkonversi secara pintar (smart conversion)
        // dari type data any ke type data tujuan
        // beda dengan java yang harus di konversi terlebih dahulu
        // example: Laptop laptop = (Laptop) any // <= java code
        println("Laptop ${any.name}")
    }else if(any is HandPhone){
        println("Headphone ${any.name}")
    }else{
        println(any)
    }
}

// recommended
fun printAnyWithWhen(any: Any){
    when(any){
        is Laptop -> println("Laptop ${any.name}")
        is SmartPhone -> println("Smart phone ${any.name} os ${any.os}")
        is HandPhone -> println("Headphone ${any.name}")
        else -> println(any)
    }
}

// bad conversion
fun printAnyAsString(any: Any){
    val string: String = any as String
    println(string)
}

fun printAnyAsStringSave(any: Any){
    val stringNullable: String? = any as? String
    println(stringNullable)
}


fun main() {
    // any data type
    printAny(1)
    printAny("Simple")
    printAny(true)

    // with conversion
    println("\nAny With conversion IF ELSE")
    printAnyWithIf(Laptop("Acer"))
    printAnyWithIf(HandPhone("Vivo"))
    printAnyWithIf("Bro")

    println("\nAny With conversion WHEN")
    printAnyWithWhen(Laptop("Acer"))
    printAnyWithWhen(HandPhone("Vivo"))
    printAnyWithWhen(SmartPhone("Iphone", "IOS"))
    printAnyWithWhen("Bro")

    // unrecommended conversion
    println("\nAny with As")
    printAnyAsString("Bro")
//    printAnyAsString(1) throw error ClassCastException
    
    // unrecommended conversion with nullable
    println("\nAny with As?")
    printAnyAsStringSave("Sis")
    printAnyAsStringSave(10) // kalau tidak bisa di konversi maka ini hasilnya null
}