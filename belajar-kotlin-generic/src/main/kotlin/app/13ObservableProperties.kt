package app

import kotlin.properties.ObservableProperty
import kotlin.reflect.KProperty

class LogObservableProperty<T>(param: T): ObservableProperty<T>(param){
    override fun afterChange(property: KProperty<*>, oldValue: T, newValue: T) {
        println("After change ${property.name} from $oldValue to $newValue")
    }

    override fun beforeChange(property: KProperty<*>, oldValue: T, newValue: T): Boolean {
        println("Before change ${property.name} from $oldValue to $newValue")
        return true
    }
}

class Car(brand: String, year: Int){
    var brand: String by LogObservableProperty<String>(brand)
    var year: Int by LogObservableProperty<Int>(year)

}
fun main() {

    val supra = Car("Toyota", 2025)

    println(supra.brand)
    println(supra.year)

    supra.brand = "Audi"
    supra.year = 2021

    println(supra.brand)
    println(supra.year)



}