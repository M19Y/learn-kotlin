package data

class Function(val name:String) {
    fun <T> hello(param: T): Unit = println("Hello $param, my name is $name")
}