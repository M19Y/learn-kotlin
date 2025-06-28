fun main() {

    saySalam("Bro")
    saySalam("Sis", null)
}

fun saySalam(firstName:String, lastName: String? = ""){
    println("Salam $firstName $lastName");
}