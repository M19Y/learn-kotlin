package com.m19y.learn.annotations

// Untuk mengecek perubahan apa yang terjadi bisa dilihat melalui kotlin decompile

@Target(AnnotationTarget.FIELD,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class Beta()

class ExampleTarget(
    @field:Beta val firstName:String,
    @param:Beta val middleName:String,
    @get:Beta val lastName:String)