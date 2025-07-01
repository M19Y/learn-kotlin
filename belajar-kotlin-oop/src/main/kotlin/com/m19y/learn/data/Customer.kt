package com.m19y.learn.data

open class Customer(val name:String, val type:String, val balance:Int) {
    constructor(name: String, type: String) :this(name, type, 0)
    constructor(name: String) :this(name, "Standard")
}

class PremiumCustomer : Customer{
    constructor(name:String) : super(name, "Premium")
    constructor(name:String, balance: Int) : super(type="Premium",  name=name, balance = balance)
}

class ExecutiveCustomer(name: String, type: String, balance: Int) : Customer(name, type, balance){
    constructor(name: String) : this(name, "Executive", 0)
}
