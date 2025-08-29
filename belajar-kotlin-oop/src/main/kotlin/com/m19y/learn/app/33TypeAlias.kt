package com.m19y.learn.app

import com.m19y.learn.temp1.Application

// import com.m19y.learn.temp2.Application // seperti ini akan terjadi conflict

typealias App1 = Application
typealias Aplikasi = App1
typealias App2 = com.m19y.learn.temp2.Application
// type alias for a function
typealias StringSupplier = () -> String
fun sayAfternoon(supplier: StringSupplier){
    println("Good Afternoon ${supplier()}")
}
fun sayNight(name:String, lam: (String) -> String){
    println("Hello ${lam(name)}, Good Night")
}
fun sayNight(name:String, lam: (String, String) -> String){
    println("Hello ${lam(name, name)}, Good Night")
}
fun main() {

    val app1 = App1("Learn Kotlin alias")
    val aplikasi = Aplikasi("Learn Kotlin alias")
    val app2 = App2("Learn Kotlin alias", "0.0.1")

    sayAfternoon { "Bro" }
    sayAfternoon({"Sis"})
    sayNight("Sis", {value: String -> value.uppercase()})
    sayNight("Sis", {value: String, value1: String -> "${value1.lowercase()} ${value.uppercase()}"})
}