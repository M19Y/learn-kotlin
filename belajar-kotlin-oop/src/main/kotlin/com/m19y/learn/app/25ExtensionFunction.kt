package com.m19y.learn.app

import com.m19y.learn.data.Student
import com.m19y.learn.data.myAge
import com.m19y.learn.data.sayHello

fun main() {

    val student = Student("Bro", 23, "Computer Science")
    student.sayHello("Sis")
    student.myAge()

    val student2: Student? = null
    student2.myAge()
    student2?.sayHello("Bro")
}