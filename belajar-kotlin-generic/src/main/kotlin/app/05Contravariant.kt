package app

// Contravariant artinya ktia bisa melakukan substitute dari parent ke child
// contravariant hanya mengizikan untuk mengeset data, dan tidak bisa mereturn data
// membuat contravariant itu harus menggunkan (in)
class Contravariant<in T>{
    fun sayHello(data: T){
        println("Hello $data")
    }

    // bisa
    fun test1(data: T): Boolean {
        println(data)
        return true
    }

    // tidak bisa mengembalikan value Generic
    // fun test2(data: T): T {
    //     return data
    // }
}

fun main() {
    val contravariantAny: Contravariant<Any> = Contravariant()
    val contravariantInt: Contravariant<Int> = contravariantAny

    contravariantInt.sayHello(100)
    contravariantInt.test1(100)
}