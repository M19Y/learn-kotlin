package com.m19y.learn.data

class Company(var name:String) {

    override fun equals(other: Any?): Boolean {
        return when(other){
            is Company -> other.name == this.name
            else -> false
        }
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }
}