package com.m19y.learn.app

import com.m19y.learn.data.Student

fun main() {
    val student = Student("Bro", 23, "Cyber Security")

    println("\nIt")
    val result1: String = student.let {
        println(it.name)
        println(it.age)
        println(it.getMajor())
        "This is a return value"
    }
    println(result1)

    println("\nRun")
    val result2: Int = student.run {
        println(this.name)
        println(this.age)
        println(this.getMajor())
        this.age // return valuenya bisa apasaja karena generic
    }
    println(result2)

    println("\nApply")
    val result3: Student= student.apply {
        println(this.name)
        println(this.age)
        println(this.getMajor())
        "This is not a return value" // tidak berpengaruh
        Student("Budi", 21, "Economic") // tidak berpengaruh
    }
    println(result3)

    println("\nAlso")
    val result4: Student = student.also {
        println(it.name)
        println(it.age)
        println(it.getMajor())
        "This is a return value" // tidak berpengaruh
    }
    println(result4)

    println("\nWith")
    val result5: Int = with(student) {
        println(this.name)
        println(this.age)
        println(this.getMajor())
        this.age // return valuenya bisa apasaja karena generic
    }
    println(result5)

}