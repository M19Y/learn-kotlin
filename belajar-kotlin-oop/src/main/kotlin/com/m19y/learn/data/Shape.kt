package com.m19y.learn.data

open class Shape {
    open val corner: Int = -1

    open fun printName(): Unit{
        println("This is Shape")
    }
}

class Rectangle: Shape(){
    final override val corner: Int = 4
    val parentCorner:Int = super.corner

    final override fun printName() {
        println("This is Rectangle")
        super.printName()
    }

}

class Triangle: Shape(){
    override val corner: Int = 3
}