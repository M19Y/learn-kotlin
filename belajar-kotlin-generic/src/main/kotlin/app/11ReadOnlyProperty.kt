package app

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class LogReadOnlyProperty(val data: String) : ReadOnlyProperty<Any, String>{
    var counter = 0
    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        counter++
        println("Print property ${property.name} with value $data")
        return data.uppercase() + counter
    }
}

class NameWithLog(param: String){
    val name: String by LogReadOnlyProperty(param)
}

fun main() {
    val nameWithLog = NameWithLog("Bro")
    println(nameWithLog.name)
    println(nameWithLog.name)
}