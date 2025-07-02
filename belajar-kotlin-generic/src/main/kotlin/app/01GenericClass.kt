package app

import data.MyData

fun main() {
    val myData: MyData<String, Int> = MyData("Bro", 100)
    println(myData)
    println(myData.getData())
    myData.printData()

    val myData1 = MyData(9, "Eleven")
    println(myData1.getSecond())
    myData1.printData()
}