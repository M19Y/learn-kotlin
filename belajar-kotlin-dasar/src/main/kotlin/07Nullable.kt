fun main() {
    var firstName = "Bro"
    println(firstName.length)

    // nullable untuk mendeklarasikannya perlu ditambhakan ? (Question marak) setelah type datanya
    // ex => Int?

    var lastName:String? = "G"
    lastName = null

    println(lastName?.length) // .length tidak akan terbaca (null)

    lastName = "Sis"

    println(lastName?.length) // .length akan terbaca 3

    var age:Int? = 10
    println(age)

}