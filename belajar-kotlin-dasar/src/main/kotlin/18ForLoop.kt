import java.sql.SQLOutput

fun main() {

    val names : Array<String> = arrayOf("Bro", "Sis", "Unc", "Aunty")

    println("Array loop")
    for (name in names) {
        println(name)
    }

    println("\nRange loop")
    for (num in 1 .. 10 step 2){
        println(num)
    }

    if("Bro" in names){
        println("Yes")
    }
}