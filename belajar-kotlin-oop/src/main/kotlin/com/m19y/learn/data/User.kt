package com.m19y.learn.data

// properties constructor
// hanya bisa di deklarasikan di primary constructor, tidak bisa pada secondary constructor
class User(var username:String, var password:String) {
    // kita tidak perlu lagi mendefinisikan pada properties classnya
    // sama seperti java record
    // var username: String = ""
    // var password: String = ""
}