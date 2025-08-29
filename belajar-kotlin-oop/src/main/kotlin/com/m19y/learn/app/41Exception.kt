package com.m19y.learn.app

import com.m19y.learn.exception.ValidationException

fun validationAndSayHello(name:String){
    if(name.isBlank()){
        throw ValidationException("Name should not be blank")
    }else if(name.startsWith("S")){
        throw Throwable("Name should not be start with S")
    }
    println("Hello $name")
}

fun main() {
    try {
        validationAndSayHello("Bro")
        validationAndSayHello("")
        validationAndSayHello("Sis")
        println("Finish")
    }catch (error: ValidationException){
        println("Validation Error: ${error.message}")
    }catch (error: Throwable){
        println("Throwable Error: ${error.message}")
    }finally {
        println("Finally will always be executed")
    }
}
