fun main() {

    // tidak menggunakan it
    val sayHello: (String) -> String = {value: String ->
        "Hello $value"
    }

    // menggunkan (it) sebagai reference 1 variable
    val sayHelloIt : (String) -> String = { "Hello $it"}

    println(sayHello("Bro"))
    println(sayHelloIt("Sis"))
}