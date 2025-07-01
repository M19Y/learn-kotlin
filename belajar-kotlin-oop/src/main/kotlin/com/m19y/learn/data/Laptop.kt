package com.m19y.learn.data

class Laptop(val name:String)
open class HandPhone(val name:String)
class SmartPhone(name:String, val os:String ): HandPhone(name)