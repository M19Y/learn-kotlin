package com.m19y.learn.app

import com.m19y.learn.annotations.NotBlank
import com.m19y.learn.exception.ValidationException
import com.m19y.learn.program.CreateProductRequest
import com.m19y.learn.program.MyApplication
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.findAnnotation

fun validate(request: Any){
    val klass = request::class
    val properties = klass.memberProperties
    for (property in properties){
        println(property)
        println(property.findAnnotation<NotBlank>())
        if(property.findAnnotation<NotBlank>() != null){
            val value = property.call(request)
            when(value){
                is String -> {
                    if(value == ""){
                        throw ValidationException("${property.name} : must not be blank")
                    }
                }
            }
        }
    }
}
fun main() {
    // untuk menggunakan anntation ini anda harus mendownloadnya manual
    // A.K.A (kotlin tidak menyediakan reflection pada standar librarynya)
    val klass = MyApplication::class
    val annotations = klass.annotations

    for (annotation in annotations){
        println(annotation)
    }

    println("\nValidate reflection")
    validate(CreateProductRequest("Bro", "a", 10))
}