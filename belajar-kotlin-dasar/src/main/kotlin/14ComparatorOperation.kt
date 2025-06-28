fun main() {
    // <, >, <=, >=, ==, !=

    val a = 100
    val b = 140

    println(a < b) // true
    println(a <= b) // true
    println(5 <= 5) // true

    println(a >= b) // false
    println(a > b) // false
    println(5 >= 5) // true

    println(a == b) // false
    println(a != b) // true

    // comparator pada string
    println("\n==== String")
    println("a" < "b") // true
    println("a" > "b") // false
    println("bro" >= "bro") // true
    println("bro" > "bro") // false
}