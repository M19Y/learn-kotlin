package com.m19y.learn.app

import com.m19y.learn.data.Friend

fun sayHello(friend: Friend?) {
    // if check
    // if(friend != null){
    //     println("Hello ${friend.name}")
    // }

    // question mark check
    // println("Hello ${friend?.name}")

    // elvis check
     println("Hello ${friend?.name ?: "Friend"}")

    // double exclamation mark (memaksa bahwa friend itu tidak mungkin null)
    // println("Hello ${friend!!.name}") // memiliki potensi error (null pointer exception)

}

fun main() {

    sayHello(Friend("Bro"))
    sayHello(null)
}