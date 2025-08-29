package app

class Invariant<T>(val name: T)
fun main() {

    val invariant = Invariant<String>("Bro")

    // tidak bisa dilakukan, karena secera default ini invariant!\
    // baik parent ke child, maupun child ke parent
    // val anyInvariant: Invariant<Any> = invariant;
}