package app

// covariant artinya kita bisa melakukan substitute subtype (child) ke supertype (parent-nya)
// covariant tidak memperbolehkan datanya diubah (set)
// covariant hanya membolehkan return value (get)

class Covariant<out T>(val data: T){
    // tidak boleh
    // fun setData(param: T): Unit = data = param

    fun data(): T = data
}

fun main() {

    // kita akan melakukan covariant dari string -> any
    val covariantString: Covariant<String> = Covariant("Bro")
    val covariantAny: Covariant<Any> = covariantString  // bisa, karena Any adalah parent dari String
    println(covariantString.data())
    println(covariantAny.data())
    println(covariantAny.data() == covariantString.data())

    // kalau dibalik ini akan gagal
    // val covariantAny1: Covariant<Any> = Covariant(10)
    // val covariantInt: Covariant<Int> = covariantAny1; // tidak bisa, meskipun Any adalah parent dari Int
    // ini bisa dilakukan jika menggunakan Contravariant -> baca file berikutnya
}