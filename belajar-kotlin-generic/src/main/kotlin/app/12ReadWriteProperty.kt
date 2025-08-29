package app

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class StringLogReadWriteProperty(var data: String): ReadWriteProperty<Any, String>{
    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        println("Get property ${property.name} with value $data")
        return data
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        println("set property ${property.name} from $data to $value")
        data = value
    }
}


class Person(param: String){
    var name: String by StringLogReadWriteProperty(param)
}

fun main() {
    val person = Person("Bro")
    println(person.name)
    person.name = "Nande"
    println(person.name)
}