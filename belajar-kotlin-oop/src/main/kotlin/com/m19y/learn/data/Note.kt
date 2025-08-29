package com.m19y.learn.data

class Note(name:String) {
    var name:String = name
        get() {
            println("\ncall getter")
            return field
        }

        set(value) {
//            field = value
            println("\ncall setter")
            if(value.isNotBlank()){
                field = value
            }
        }
}

class BigNote(val title:String){
    val bigTitle: String
        get() = title.uppercase()
}