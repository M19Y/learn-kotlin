package com.m19y.learn.data

// inheritance
// parent
open class Employee(val name:String) {
    open fun sayHello(name: String): Unit{
        println("Hello $name, my name is ${this.name}")
    }
}

// child
open class Manager(name:String): Employee(name){
    // secara default jika melakukan override function
    // maka functionnya akan otomatis open pada childnya, jika class ini memiliki child
    override fun sayHello(name: String) {
        println("Hello $name, my name is Manager ${this.name}")
    }
}

open class SuperManager(name: String) : Manager(name){
    // apabila function ini tidak mau di override lagi oleh child-nya
    // kita bisa menambahkan final pada function ini
    final override fun sayHello(name: String) {
        println("Hello $name, my name is Super Manager ${this.name}")
    }
}

open class SuperSuperManager(name: String): SuperManager(name){
    // tidak bisa melakukan override
    /*override fun sayHello(name: String){
        println("Hello $name, my name is Super Super Manager ${this.name}")
    }*/
}

// child
final class VicePresident(name:String): Employee(name){
    final override fun sayHello(name: String) {
        println("Hello $name, my name is Vice President ${this.name}")
    }
}