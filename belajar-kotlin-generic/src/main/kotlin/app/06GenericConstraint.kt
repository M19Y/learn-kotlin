package app

// hanya bisa menggunakan class itu sendiri dan turunannya
open class Employee
class Manager: Employee()
class VicePresident: Employee(), CanSayHello{
    override fun sayHello(name: String) {
        println("Hello $name, i'm vice president")
    }
}
class Company<T: Employee>(employee: T)

interface CanSayHello{
    fun sayHello(name: String)
}
// big company hanya bisa menggunakan class yang mengextends Employee dan CanSayHello
class BigCompany<T>(employee: T) where T: Employee, T: CanSayHello

fun main() {

    // hanya bisa mebaca class generic employee dan turunannya
    // tidak bisa membaca class lain seperti Any, String, Int dsb
    val data1: Company<Employee> = Company(Employee())
    val data2: Company<Manager> = Company(Manager())
    val data3: Company<VicePresident> = Company(VicePresident())
    // val data4: Company<String> = Company("Not allowed") // <- Tidak bisa

    // val data5: BigCompany<Employee> = BigCompany(Employee()) // <- Tidak bisa
    // val data6: BigCompany<Manager> = BigCompany(Manager())// <- Tidak bisa

    // hanya bisa membaca class yang mengextend Employee dan mengimplements CanSayHello
    val data7: BigCompany<VicePresident> = BigCompany(VicePresident())
}