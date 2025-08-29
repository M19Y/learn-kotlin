package app
class Container<T>(var data: T)

fun copyContainer(from: Container<out Any>, to: Container<in Any>){
    // from cuman mengembalikan data (read only)
    // to nya berfungsi mengeset data (set only)
    to.data = from.data
}

fun main() {

    val container1 = Container<String>("Bro")
    val container2 = Container<Any>("Sis")
    copyContainer(container1, container2)

    println(container1.data)
    println(container2.data)
}