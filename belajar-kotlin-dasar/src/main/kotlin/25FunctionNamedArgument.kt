fun main() {
    fullName("Son", "Goku", "DG")
    fullName(lastName = "DG", middleName = "Gohan", firstName = "Son")

    // fullName(lastName = "DG", middleName = "Gohan", "Son") // tidak bisa mix
    // fullName(lastName = "DG", middleName = "Gohan") // semua parameter harus memiliki value (kecuali memiliki default)



}

fun fullName(firstName:String, middleName:String, lastName:String){
    println("Hello $firstName $middleName $lastName")
}