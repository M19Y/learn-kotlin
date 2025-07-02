package app

class Data<T>(val data:T)

fun Data<String>.print() = {
    val data: String = this.data
    println(data)
}

fun main() {
    val dataStr: Data<String> = Data("Bro")
    val dataInt: Data<Int> = Data(911)

    dataStr.print()// bisa
    // dataInt.print() // tidak bisa
}