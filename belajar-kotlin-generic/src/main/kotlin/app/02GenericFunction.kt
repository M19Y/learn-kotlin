package app
import data.Function

fun main() {

    val function = Function("Bro");
    function.hello("Bro")
    function.hello<String>("Sis")

    val functionInt = Function("Unc")
    functionInt.hello(10)
    functionInt.hello<Int>(10)

}