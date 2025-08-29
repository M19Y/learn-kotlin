package com.m19y.learn.data

sealed class Operation(val name: String)
class Plus: Operation("Plus")
class Minus: Operation("Minus")