package com.m19y.learn.app

import com.m19y.learn.data.Boss

fun main() {

    val boss1 = Boss("M19y")
    val employee1 = boss1.Employee("Son Goku")
    val employee2 = boss1.Employee("Son Gohan")

    val boss2 = Boss("Picollo")
    val employee3 = boss2.Employee("Crilin")
    val employee4 = boss2.Employee("Sega")

    employee1.hi(employee2.name)
    employee2.hi(employee3.name)
    employee3.hi(employee4.name)
    employee4.hi(employee1.name)
}