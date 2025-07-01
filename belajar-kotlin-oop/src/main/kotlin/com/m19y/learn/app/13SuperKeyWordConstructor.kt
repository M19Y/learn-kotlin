package com.m19y.learn.app

import com.m19y.learn.data.Customer
import com.m19y.learn.data.ExecutiveCustomer
import com.m19y.learn.data.PremiumCustomer

fun main() {
    val standardCustomer = Customer("Bro")
    printCustomer(standardCustomer)

    val premiumCustomer = PremiumCustomer("Sis")
    printCustomer(premiumCustomer)

    val executiveCustomer = ExecutiveCustomer("Unc")
    printCustomer(executiveCustomer)

}

fun printCustomer(customer: Customer){
    println(customer.name)
    println(customer.balance)
    println(customer.type)
    print("\n")
}