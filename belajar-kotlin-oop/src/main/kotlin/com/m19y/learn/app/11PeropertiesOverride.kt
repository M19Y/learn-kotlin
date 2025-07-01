package com.m19y.learn.app

import com.m19y.learn.data.Rectangle
import com.m19y.learn.data.Shape
import com.m19y.learn.data.Triangle

fun main() {
    val shape = Shape()
    println(shape.corner)

    val rectangle = Rectangle()
    println(rectangle.corner)

    val triangle = Triangle()
    println(triangle.corner)

}