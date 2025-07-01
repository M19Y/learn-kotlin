package com.m19y.learn.data

class Product(var name:String, var price:Int, var quantity:Int){
    override fun toString(): String {
        return "Product { name: $name, price: $price, quantity: $quantity }"
    }
}