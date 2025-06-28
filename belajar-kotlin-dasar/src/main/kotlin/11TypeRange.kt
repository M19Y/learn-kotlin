fun main() {

    println("===== Range")
    val range = 2 .. 10

    println(range.count()) // 9
    println(range.contains(5)) // true
    println(range.first) // 2
    println(range.last) // 10
    println(range.step) // 1

    // reverse range
    println("\n===== Revers range")
    val reverseRange = 10 downTo 2

    println(range.count()) // 9
    println(range.contains(5)) // true
    println(range.first) // 10
    println(range.last) // 2
    println(range.step) // 1

    // range dengan step
    println("\n===== Range with step")
    val rangeWithStep = 1 .. 10 step 2

    println(rangeWithStep.contains(6)) // false
    println(rangeWithStep.step) // 2
}