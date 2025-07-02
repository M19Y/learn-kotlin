package app

fun displayLength(array: Array<*>) = println("Length array is ${array.size}")

fun main() {
    val arrayStr: Array<String> = arrayOf("Bro", "Sis", "Unc", "Aunty", "Grandpa", "Grandma")
    val arrayInt: Array<Int> = arrayOf(9, 11, 2001)

    displayLength(arrayStr)
    displayLength(arrayInt)
}