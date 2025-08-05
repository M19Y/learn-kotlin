package com.m19y.learn.data

class Color(val name: String) {
    override fun equals(other: Any?): Boolean = when (other) {
        is Color -> name == other.name
        else -> false
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }
}