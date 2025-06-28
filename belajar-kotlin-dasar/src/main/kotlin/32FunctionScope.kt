fun global1(){
    println("This is global 1 function")
}

fun global2(){
    global1()
    println("This is global 2 function")
}

fun global3(){
    global2()
    println("This is global 3 function")
     // local1() tidak bisa memanggil method yang ada dalam scope function lain
}

fun main() {
    fun local1(){
        println("This is inner function, (local)")
    }

    // hanya bisa dipanggil dalam scope parent-nya
    local1()

    // fun global bisa di panggil di function apa saja
    global3()
}