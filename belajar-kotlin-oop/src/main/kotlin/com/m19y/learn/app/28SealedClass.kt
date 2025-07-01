package com.m19y.learn.app

import com.m19y.learn.data.Minus
import com.m19y.learn.data.Operation
import com.m19y.learn.data.Plus

fun main() {
    fun operation(a: Int, b: Int, op: Operation): Int{
        return when(op){
            is Plus -> a + b
            is Minus -> a - b
        }
    }

    println(operation(9, 11, Plus())) // 20
    println(operation(9, 11, Minus())) // -2

}