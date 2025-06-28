fun toUpper(param:String):String {
    return param.uppercase()
}

fun main() {

    // lambda method reference
    val nameToUpper: (String) -> String = ::toUpper

    println(nameToUpper("Bro"))
}