fun factorial(num: Int) : Int {
    var result = 1;
    for (i in num downTo 1){
        result *=i
    }
    return result;
}


fun factorialRecursion(num: Int) : Int{
    // 5
    // 5 * 24 = 120
    // 4 * 6 = 24
    // 3 * 2 = 6
    // 2 * 1 = 2
    // 1 -> return

    println(num)
    return when(num){
        1 -> 1
        else -> num * factorialRecursion(num - 1)
    }
}

fun main() {
    println(factorial(5)) // harus 120
    println(factorialRecursion(5)) // harus 120
}