package com.m19y.learn.program

import com.m19y.learn.annotations.Fancy

@Fancy(author = "Bro")
class MyApplication(val name:String, val version: Int) {
    fun info(): String = "Application $name-$version"
}