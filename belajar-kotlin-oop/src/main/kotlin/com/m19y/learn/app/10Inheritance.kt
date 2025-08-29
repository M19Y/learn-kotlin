package com.m19y.learn.app

import com.m19y.learn.data.Employee
import com.m19y.learn.data.Manager
import com.m19y.learn.data.VicePresident

fun main() {
    /*
    Inheritance adalah kemampuan class lain melakukan reference ke kelas lain
    dalam hal ini parent and child
    class parent bisa memiliki banyak child
    sedangkan class child hanya bisa memiliki satu class parent
    */

    val employee = Employee("Bro");
    employee.sayHello("Sis")

    val manager = Manager("Son Gohan")
    manager.sayHello("Picollo")

    val vicePresident = VicePresident("Son Goku")
    vicePresident.sayHello("Vegeta")
}