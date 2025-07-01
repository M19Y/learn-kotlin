package com.m19y.learn.app

import com.m19y.learn.data.Person

fun main() {
    /*
     syarat membuat function overloading adalah
     parameter pada functionnya harus berbeda
     baik itu jumlah ataupun tipe data.
     overloading akan error jika
     1. parameter sama
     2. return value beda tapi parameter sama
     Contoh yang benar:

     fun sayHello(name: String)
     fun sayHello(name: String, age:Int)
     fun sayHello(age:Int)

     Contoh yang salah:

     fun sayHello(name:String): Unit
     fun sayHello(name:String): String
     */

    val person = Person()
    person.firstName = "Bro"
    person.middleName = "G"
    person.lastName = "New york"

    person.sayHello("Sis")
    person.sayHello("Sis", "New Jersey")
}