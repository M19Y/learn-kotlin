package data

class Fruit(val name: String, var quantity: Int): Comparable<Fruit>{
    override fun compareTo(other: Fruit): Int = quantity.compareTo(other.quantity)
}