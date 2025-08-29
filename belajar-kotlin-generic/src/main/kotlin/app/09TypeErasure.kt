package app

// semua generic akan silang saat runtime
// generic hanya berfungsi saat compile time
class TypeErasure<T>(param: T){
    private val data: T = param
    fun getData(): T = this.data
}

fun main() {
    val data1: TypeErasure<String> = TypeErasure("Bro")
    val resultData1: String = data1.getData()
    println(resultData1)

    println("\nCoba conversi")
    val data2: TypeErasure<Int> = data1 as TypeErasure<Int> // bahaya (karena ini valid) tapi akan error saat runtime
    val resultData2: Int = data2.getData()
    println(resultData2)
}