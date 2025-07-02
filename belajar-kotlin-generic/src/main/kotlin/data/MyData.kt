package data

class MyData<T, G>(private val firstData: T, private val secondData: G) {
    fun getData(): T = firstData
    fun getSecond(): G = secondData
    fun printData(): Unit = println("Data is $firstData $secondData")
}