package com.m19y.learn.data

interface Base {
    fun sayMorning(name:String)
    fun sayHi(name:String)
}

class MyBase: Base{
    override fun sayMorning(name: String) {
        println("Good Morning $name")
    }

    override fun sayHi(name: String) {
        println("Hi $name")
    }
}

class MyBaseDelegate(val base: Base): Base{
    override fun sayMorning(name: String) {
        base.sayMorning(name)
    }

    override fun sayHi(name: String) {
        base.sayHi(name)
    }
}

class MyBaseDelegateBy(val base: Base): Base by base{
    // secara default ini akan meng-override semua function dan mendelegasikannya pada base yang dikirimkan
    // kita juga bisa mengoverridenya secara manual
    override fun sayMorning(name: String) {
        println("Happy birthday $name")
    }
}