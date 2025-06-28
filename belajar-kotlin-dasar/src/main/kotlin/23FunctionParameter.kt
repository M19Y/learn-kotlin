fun main() {
    sayHello("Sis")
    sayMorning("Uncle", null)
    sayMorning("Aunty", "Jessica")

}

fun sayHello(name:String){
    // name = "Bro", by default parameter adalah val (immutable) tidak bisa di ubah
    println("Hello $name")
}

fun sayMorning(firstName:String, lastName: String?){
    if(lastName == null){
        println("Morning $firstName")
    }else{
        println("Morning $firstName $lastName")
    }
}