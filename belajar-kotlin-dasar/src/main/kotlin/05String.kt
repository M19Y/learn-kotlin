fun main() {
    var firstName: String = "Bro"
    var lastName: String = "G"
    var age: Int = 23
    var address: String = """
        >Jalan: Lower Manhattan,
        >Kota: New York City,
        >Provinsi: New York,
        >Negara: United State
    """.trimMargin(">")

    println(firstName)
    println(age)
    println(address)

    // Mengabungkan String
    println(firstName + " " + lastName) // normal concatenate
    println("$firstName $lastName") // strubg template

    println("Total length $firstName = ${firstName.length}")

}