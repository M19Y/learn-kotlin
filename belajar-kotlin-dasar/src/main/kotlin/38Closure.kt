fun main() {

    var counter: Int = 0

    val lambdaIncrement: () -> Unit = {
        println("Lambda increment")
        counter++
    }

    val anonymousIncrement = fun():Unit {
        println("Anonymous increment")
        counter++
    }

    fun functionIncrement(): Unit{
        println("Function increment")
        counter++
    }

    lambdaIncrement()
    anonymousIncrement()
    functionIncrement()

    println(counter)
}