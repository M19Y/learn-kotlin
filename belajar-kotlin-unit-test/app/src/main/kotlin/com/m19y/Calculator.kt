package com.m19y

class Calculator {

    fun add(first: Int, second: Int): Int = first + second
    fun divide(first: Int, second: Int): Int {
        /*if(second == 0){
            throw IllegalArgumentException("Can not divide by zero")
        }else{
            return first / second
        }*/
        when {
            second == 0 -> throw IllegalArgumentException("Can not divide by zero")
            else -> return first / second
        }

    }
}