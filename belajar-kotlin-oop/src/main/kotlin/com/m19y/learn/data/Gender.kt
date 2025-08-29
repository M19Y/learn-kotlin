package com.m19y.learn.data

enum class Gender(val description: String) {
    MALE("Male"),
    FEMALE("Female");

    fun showDesc(): String{
        return this.description
    }
}