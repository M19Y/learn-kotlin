fun main() {

    // higher order function
    fun hello(name:String, transformer: (String) -> String):String {
        val nameTransform = transformer(name)
        return "Hello $nameTransform"
    }

    val lambdaUpper: (String) -> String = {value:String -> value.uppercase()}
    val lambdaUpper2: (String) -> String = {it.uppercase()}

    val lambdaLower = {value: String -> value.lowercase()}

    println(hello("Bro", lambdaUpper))
    println(hello("Bro", lambdaUpper2))

    println(hello("Bro", lambdaLower))

    println("\nWithout Trailing lambda")
    println(hello("Bro", { it.lowercase() })) // bisa di masukan langsung

    // trailing lambda (syaratnya lambdanya harus menjadi parameter paling akhir
    println("\nTrailing lambda")
    println(hello("Bro") { it.uppercase() })

}