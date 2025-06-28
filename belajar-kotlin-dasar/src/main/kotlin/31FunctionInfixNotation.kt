infix fun String.to(type:String) :String {
    if(type == "UP"){
        return this.uppercase()
    }
    return this.lowercase()
}

fun main() {

    // cara 1 memaggil infix function
    val upper = "Son Gohan DG" to "UP"
    println(upper)

    // cara 2 memanggil infix function seperti fungsi biasa
    val lower = "Son Goku DG".to("lower")
    println(lower)

    // function infix ini sama seperti downTo pada reverse range
    for (i in 10.downTo(1)){
        println(i)
    }
}