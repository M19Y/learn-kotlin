// lambda diggunakan untuk kasus sederhana, sedangkan anonymous function bisa yang complex
// yang menggunakan if else dan return

fun main() {

    fun hello(name:String, transformer: (String) -> String):String {
        val nameTransform = transformer(name)
        return "Hello $nameTransform"
    }

    // normal function
    fun upper(name:String): String{
        if(name == ""){
            return "Ups"
        }
        return name.uppercase()
    }

    // anonymous function
    val anonymousUpper = fun(name: String): String {
        if(name == ""){
            return "Ups"
        }
        return name.uppercase()
    }

    // anonymous upper juga bisa diggunakan sebagai penganti lambda
    println(hello("Bro", anonymousUpper))
    println(hello("", anonymousUpper))

    println("\nAs a parameter")
    // menggunakan lambda
    println(hello("Sis") {it.uppercase()})
    // menggunakan anonymous function
    println(hello("Sis", fun(name:String): String{ return name.lowercase()}))

}